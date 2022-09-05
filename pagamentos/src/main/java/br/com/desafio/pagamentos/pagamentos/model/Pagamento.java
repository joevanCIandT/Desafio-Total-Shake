package br.com.desafio.pagamentos.pagamentos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private String nome;

    private String numero;

    private String expiracao;

    private String codigo;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Long pedidoId;

    @Enumerated(EnumType.STRING)
    private FormaDePagamento formaDePagamento;


    public Pagamento(BigDecimal valor, String nome, String numero, String expiracao, String codigo, Status status, FormaDePagamento formaDePagamento, Long pedidoId) {
        this.valor = valor;
        this.nome = nome;
        this.numero = numero;
        this.expiracao = expiracao;
        this.codigo = codigo;
        this.status = status;
        this.formaDePagamento = formaDePagamento;
        this.pedidoId = pedidoId;
    }
}
