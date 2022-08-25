package br.com.desafio.totalshake.controller;


import br.com.desafio.totalshake.dto.ItemPedidoDTO;
import br.com.desafio.totalshake.dto.PedidoDTO;
import br.com.desafio.totalshake.form.AtualizacaoItemPedidoForm;
import br.com.desafio.totalshake.form.AtualizacaoPedidoForm;
import br.com.desafio.totalshake.form.PedidoForm;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import br.com.desafio.totalshake.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    private final PedidoService pedidoService;


    @Autowired
    public PedidoController(PedidoRepository pedidoRepository, PedidoService pedidoService){
        this.pedidoRepository = pedidoRepository;
        this.pedidoService = pedidoService;
    }

    @GetMapping("/all")
    public Page<PedidoDTO> listaPedidos(@PageableDefault(sort = "dataHora", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao){

        Page<Pedido> pedidos = pedidoRepository.findAll(paginacao);
        return PedidoDTO.converter(pedidos);

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PedidoDTO> cadastrar(PedidoForm pedidoForm){
        Pedido pedido = pedidoForm.converter();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
        pedidoService.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPedidoForm form) {
        return pedidoService.atualizaPedido(id, form);
    }
}
