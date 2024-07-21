package pt.amane.order_service.service;

import org.springframework.stereotype.Service;
import pt.amane.order_service.dto.OrderRequest;

@Service
public interface OrderService {

  String placeOrder(OrderRequest orderRequest);

}
