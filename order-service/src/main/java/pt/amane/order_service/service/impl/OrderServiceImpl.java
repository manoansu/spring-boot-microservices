package pt.amane.order_service.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import pt.amane.order_service.dto.InventoryResponse;
import pt.amane.order_service.dto.OrderLineItemsDto;
import pt.amane.order_service.dto.OrderRequest;
import pt.amane.order_service.model.Order;
import pt.amane.order_service.model.OrderLineItems;
import pt.amane.order_service.repository.OrderRepository;
import pt.amane.order_service.service.OrderService;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final WebClient.Builder webClientBuilder;
  //  private final ObservationRegistry observationRegistry;
  private final ApplicationEventPublisher applicationEventPublisher;

  @Override
  public String placeOrder(OrderRequest orderRequest) {

    Order order = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());

    List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
        .stream()
        .map(this::mapToOrder)
        .toList();

    order.setOrderLineItems(orderLineItems);

    List<String> skuCodes = order.getOrderLineItems()
        .stream()
        .map(OrderLineItems::getSkuCode)
        .toList();

    // Call Inventory service, and place order if product is in stock
    InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
        .uri("http://inventory-service/api/inventory",
            uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
        .retrieve()
        .bodyToMono(InventoryResponse[].class)
        .block();

    boolean allProductsInStock = Arrays.stream(inventoryResponseArray)
        .allMatch(InventoryResponse::isInStock);

    if (allProductsInStock) {
      orderRepository.save(order);
    } else {
      throw new IllegalArgumentException("Product is not in stock, please try again later");
    }
//    Observation inventoryServiceObservation = Observation.createNotStarted("inventory-service-lookup", this.observationRegistry);

    return inventoryResponseArray.toString();
  }

  private OrderLineItems mapToOrder(OrderLineItemsDto orderLineItemsDto) {
    OrderLineItems orderLineItems = new OrderLineItems();
    orderLineItems.setId(orderLineItemsDto.getId());
    orderLineItems.setPrice(orderLineItemsDto.getPrice());
    orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
    orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
    orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

    return orderLineItems;
  }
}
