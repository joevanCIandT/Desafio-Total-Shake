package br.com.desafio.totalshake.form;

import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ItemPedidoForm {

    @NotNull
    private Integer quantidade;

    @NotNull
    @NotEmpty
    @Length(min = 4)
    private String descricao;

    @NotNull
    private Long pedido_id;

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public ItemPedido converter(PedidoRepository pedidoRepository) {

        Optional<Pedido> pedido = pedidoRepository.findById(pedido_id);
        return pedido.map(value -> new ItemPedido(quantidade, descricao, value)).orElse(null);

    }
}
