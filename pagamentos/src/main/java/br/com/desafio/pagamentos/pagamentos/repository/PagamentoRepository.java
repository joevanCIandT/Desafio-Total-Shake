package br.com.desafio.pagamentos.pagamentos.repository;

import br.com.desafio.pagamentos.pagamentos.model.Pagamento;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    @Query("SELECT p FROM Pagamento p WHERE p.pedidoId = :pedido")
    List<Pagamento> findByPedido(@Param("pedido") Long pedidoId);


}
