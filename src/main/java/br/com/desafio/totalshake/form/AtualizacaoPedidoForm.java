package br.com.desafio.totalshake.form;

import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoPedidoForm {


    @NotNull
    private Integer status;

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Pedido atualizar(Long id, PedidoRepository pedidoRepository) {

        Pedido pedido = pedidoRepository.getReferenceById(id);
        pedido.setStatus(Status.ENTREGUE);
        return pedido;
    }
}
