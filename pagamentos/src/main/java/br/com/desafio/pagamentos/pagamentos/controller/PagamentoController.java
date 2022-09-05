package br.com.desafio.pagamentos.pagamentos.controller;

import br.com.desafio.pagamentos.pagamentos.config.PedidoProxy;
import br.com.desafio.pagamentos.pagamentos.dto.PagamentoDTO;
import br.com.desafio.pagamentos.pagamentos.form.PagamentoForm;
import br.com.desafio.pagamentos.pagamentos.model.Pagamento;
import br.com.desafio.pagamentos.pagamentos.repository.PagamentoRepository;
import br.com.desafio.pagamentos.pagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PedidoProxy proxy;

    private final PagamentoRepository pagamentoRepository;

    private final PagamentoService pagamentoService;

    @Autowired
    public PagamentoController(PagamentoRepository pagamentoRepository, PagamentoService pagamentoService) {
        this.pagamentoRepository = pagamentoRepository;
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/{id}")
    public PagamentoDTO retornaPagamento(
            @PathVariable Long id
    ){

        List<Pagamento> pagamentos = pagamentoRepository.findByPedido(id);

        ResponseEntity<Map> responseEntity = proxy.retrieveExchangeValue(pagamentos.get(0).getPedidoId());

        Map<?, ?> responsePedido = responseEntity.getBody();

        Object pedido = responsePedido.get("id");

        Long pedidoId =Long.parseLong(pedido.toString());

        pagamentos.get(0).setPedidoId(pedidoId);

        return new PagamentoDTO(pagamentos.get(0));

    }



    @PostMapping()
    public PagamentoDTO cadastra( @RequestBody @Valid PagamentoForm pagamentoForm) {
        Pagamento pagamento = pagamentoForm.converter(pagamentoRepository);

        pagamentoService.cadastraPagamento(pagamento);

        proxy.atualizaStatusPedido(pagamento.getPedidoId(), "PAGO");

        return new PagamentoDTO(pagamento);

    }



}
