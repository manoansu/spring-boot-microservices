package pt.amane.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.amane.order_service.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
