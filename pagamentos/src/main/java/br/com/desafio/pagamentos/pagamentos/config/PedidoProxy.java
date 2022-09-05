package br.com.desafio.pagamentos.pagamentos.config;

import br.com.desafio.pagamentos.pagamentos.model.Pagamento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@FeignClient(name="totalshake")
public interface PedidoProxy {

    @GetMapping("pedidos/{id}")
    public ResponseEntity<Map> retrieveExchangeValue(
            @PathVariable Long id);

    @PutMapping("pedidos/{id}")
    public ResponseEntity<Map> atualizaStatusPedido(
            @PathVariable Long id,
            @PathVariable String status
            );
}
