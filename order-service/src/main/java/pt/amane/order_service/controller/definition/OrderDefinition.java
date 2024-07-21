package pt.amane.order_service.controller.definition;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
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
  @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
  @TimeLimiter(name = "inventory")
  @Retry(name = "inventory")
  CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest);

  CompletableFuture<String> fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException);

}
