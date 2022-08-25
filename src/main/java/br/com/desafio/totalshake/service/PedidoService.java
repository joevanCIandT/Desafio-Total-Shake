package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.ItemPedidoDTO;
import br.com.desafio.totalshake.dto.PedidoDTO;
import br.com.desafio.totalshake.form.AtualizacaoPedidoForm;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {

        this.pedidoRepository = pedidoRepository;
    }


    public ResponseEntity<PedidoDTO> findAllPedidos() {
        return ResponseEntity.ok(new PedidoDTO((Pedido) pedidoRepository.findAll()));
    }


    public ResponseEntity<PedidoDTO> cadastraPedido(Pedido pedido) {

        return ResponseEntity.ok(new PedidoDTO(pedidoRepository.save(pedido)));
    }

    public void deletePedido(Long id) {

        pedidoRepository.deletePedidoById(id);
    }


    public ResponseEntity<PedidoDTO> atualizaPedido(Long id, AtualizacaoPedidoForm form) {

        Optional<Pedido> optional = pedidoRepository.findById(id);

        if (optional.isPresent()) {
            Pedido pedido = form.atualizar(id, pedidoRepository);
            return ResponseEntity.ok(new PedidoDTO(pedido));
        }
        return ResponseEntity.notFound().build();
    }
}
