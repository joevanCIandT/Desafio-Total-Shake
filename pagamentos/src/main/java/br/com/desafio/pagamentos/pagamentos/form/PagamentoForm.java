package br.com.desafio.pagamentos.pagamentos.form;

import br.com.desafio.pagamentos.pagamentos.model.FormaDePagamento;
import br.com.desafio.pagamentos.pagamentos.model.Pagamento;
import br.com.desafio.pagamentos.pagamentos.model.Status;
import br.com.desafio.pagamentos.pagamentos.repository.PagamentoRepository;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Optional;

@Data
public class PagamentoForm {

    private BigDecimal valor;

    private String nome;

    private String numero;

    private String expiracao;

    private String codigo;

    private String status;

    private Long pedidoId;

    private String formaDePagamento;

    public Pagamento converter(PagamentoRepository pedidoRepository) {

        return new Pagamento(valor, nome, numero , expiracao, codigo, Status.CRIADO , FormaDePagamento.PIX,  pedidoId);

    }

}
