package br.com.desafio.totalshake.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status =  Status.REALIZADO;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="pedido")
    private List<ItemPedido> itensPedidoList = new ArrayList<>();


    public Pedido(LocalDateTime dataHora, Status status, List<ItemPedido> itensPedidoList) {
        this.dataHora = dataHora;
        this.status = status ;
        this.itensPedidoList = itensPedidoList;
    }

}
