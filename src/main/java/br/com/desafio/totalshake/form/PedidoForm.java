package br.com.desafio.totalshake.form;

import br.com.desafio.totalshake.model.Pedido;
import org.hibernate.validator.constraints.Length;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PedidoForm {


    public Pedido converter() {
        return new Pedido();

    }

}
