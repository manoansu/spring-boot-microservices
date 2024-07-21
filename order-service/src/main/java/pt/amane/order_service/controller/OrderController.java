package pt.amane.order_service.controller;

import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pt.amane.order_service.controller.definition.OrderDefinition;
import pt.amane.order_service.dto.OrderRequest;
import pt.amane.order_service.service.OrderService;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderDefinition {

  private final OrderService orderService;

//  @Override
//  public CompletableFuture<String> placeOrder(OrderRequest orderRequest) {
//    return null;
//  }

  @Override
  public String placeOrder(OrderRequest orderRequest) {
    orderService.placeOrder(orderRequest);
    return "Order placed Successfully";
  }

  @Override
  public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest,
      RuntimeException runtimeException) {
    return null;
  }
}
