package pt.amane.order_service.controller.definition;

import java.util.concurrent.CompletableFuture;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import pt.amane.order_service.dto.OrderRequest;

@RequestMapping("/api/order")
public interface OrderDefinition {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  String placeOrder(@RequestBody OrderRequest orderRequest);
//  CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest);

  CompletableFuture<String> fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException);

}
