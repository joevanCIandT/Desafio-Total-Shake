package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.ItemPedidoDTO;
import br.com.desafio.totalshake.form.AtualizacaoItemPedidoForm;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public ItemPedido cadastraItem(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public ResponseEntity<ItemPedidoDTO> atualizaItem(Long id, AtualizacaoItemPedidoForm form) {

        Optional<ItemPedido> optional = itemPedidoRepository.findById(id);

        if (optional.isPresent()) {
            ItemPedido itemPedido = form.atualizar(id, itemPedidoRepository);
            return ResponseEntity.ok(new ItemPedidoDTO(itemPedido));
        }
        return ResponseEntity.notFound().build();

    }

    public ResponseEntity<?> removeItem(Long id) {

        Optional<ItemPedido> optional = itemPedidoRepository.findById(id);
        if (optional.isPresent()) {
            itemPedidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
