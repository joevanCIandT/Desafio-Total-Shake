package br.com.desafio.totalshake.repository;

import br.com.desafio.totalshake.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    void deletePedidoById(Long id);
}
