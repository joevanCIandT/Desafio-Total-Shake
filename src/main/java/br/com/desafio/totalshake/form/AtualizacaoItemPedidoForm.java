package br.com.desafio.totalshake.form;

import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoItemPedidoForm {

    @NotNull
    private Integer quantidade;

    @NotNull
    @NotEmpty
    @Length(min = 4)
    private String descricao;


    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public ItemPedido atualizar(Long id, ItemPedidoRepository itempedidoRepository) {

        ItemPedido item = itempedidoRepository.getReferenceById(id);
        item.setQuantidade(this.quantidade);
        item.setDescricao(this.descricao);
        return item;
    }
}






