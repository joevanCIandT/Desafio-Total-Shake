package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoDTO {


    private String dataHora;

    private Status status;

    private List<ItemPedido> itensPedidoList;


    public PedidoDTO(Pedido pedido){
        this.dataHora = convertDataEHora(pedido.getDataHora());
        this.status = pedido.getStatus();
        if(pedido.getItensPedidoList().isEmpty()){

            this.itensPedidoList = new ArrayList<>() ;
        }else{
            System.out.println("pedido nao e nulo");
            for(ItemPedido item : pedido.getItensPedidoList() ){
                System.out.println(item.getDescricao());
            }
            this.itensPedidoList = pedido.getItensPedidoList() ;
        }
    }

    public String convertDataEHora(LocalDateTime dataHora){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataHora.format(formatter);
    }

    public static Page<PedidoDTO> converter(Page<Pedido> pedidos) {

        return pedidos.map(PedidoDTO::new);
    }

}
