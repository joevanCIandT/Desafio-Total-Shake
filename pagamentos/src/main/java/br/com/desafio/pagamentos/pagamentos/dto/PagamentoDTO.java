package br.com.desafio.pagamentos.pagamentos.dto;

import br.com.desafio.pagamentos.pagamentos.model.FormaDePagamento;
import br.com.desafio.pagamentos.pagamentos.model.Pagamento;
import br.com.desafio.pagamentos.pagamentos.model.Status;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class PagamentoDTO {

    private BigDecimal valor;

    private String nome;

    private String numero;

    private String expiracao;

    private String codigo;


    private String status;

    private Long pedidoId;


    private String formaDePagamento;

    public PagamentoDTO(Pagamento pagamento) {

        this.valor = pagamento.getValor();
        this.nome = pagamento.getNome();
        this.numero = pagamento.getNumero();
        this.expiracao = pagamento.getExpiracao();
        this.codigo = pagamento.getCodigo();
        this.status = pagamento.getStatus().toString();
        this.pedidoId = pagamento.getId();;
        this.formaDePagamento = pagamento.getFormaDePagamento().toString();

    }
}
