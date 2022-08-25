package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.ItemPedidoDTO;
import br.com.desafio.totalshake.form.AtualizacaoItemPedidoForm;
import br.com.desafio.totalshake.form.ItemPedidoForm;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import br.com.desafio.totalshake.repository.PedidoRepository;
import br.com.desafio.totalshake.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("pedidos/itens")
public class ItemPedidoController {

    private final ItemPedidoRepository itemPedidoRepository;

    private final PedidoRepository pedidoRepository;

    private final ItemPedidoService itemPedidoService;

    @Autowired
    public ItemPedidoController(ItemPedidoRepository itemPedidoRepository, PedidoRepository pedidoRepository, ItemPedidoService itemPedidoService) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoService = itemPedidoService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemPedido cadastrar(@RequestBody @Valid ItemPedidoForm itemPedidoForm){
        ItemPedido itemPedido = itemPedidoForm.converter(pedidoRepository);
        return itemPedidoService.cadastraItem(itemPedido);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ItemPedidoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoItemPedidoForm form) {
        return itemPedidoService.atualizaItem(id, form);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return itemPedidoService.removeItem(id);

    }

}
