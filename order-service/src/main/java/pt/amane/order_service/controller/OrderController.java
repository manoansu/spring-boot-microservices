package pt.amane.order_service.controller;

import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pt.amane.order_service.controller.definition.OrderDefinition;
import pt.amane.order_service.dto.OrderRequest;
import pt.amane.order_service.service.OrderService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController implements OrderDefinition {

  private final OrderService orderService;


  @Override
  public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
    log.info("Placing Order");
    return CompletableFuture.supplyAsync(() -> orderService.placeOrder(orderRequest));
  }

  public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
    log.info("Cannot Place Order Executing Fallback logic");
    return CompletableFuture.supplyAsync(() -> "Oops! Something went wrong, please order after some time!");
  }
}
