package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Cacheable("pedidos")
    List<Pedido> findByStatusPedido(StatusPedido status, Pageable paginacao);
    List<Pedido> findByStatusPedidoAndUser_Username(StatusPedido status, String username);
    List<Pedido> findAllByUser_Username(String username);
}
