package pt.amane.inventory_service.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.amane.inventory_service.dto.InventoryResponse;
import pt.amane.inventory_service.model.Inventory;
import pt.amane.inventory_service.repository.InventoryRepository;
import pt.amane.inventory_service.service.InventoryService;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

  private final InventoryRepository inventoryRepository;

  @Override
  @SneakyThrows
  public List<InventoryResponse> isInStock(List<String> skuCode) {
    log.info("Wait Started");
    Thread.sleep(10000);
    log.info("Wait Ended");
    return inventoryRepository.findBySkuCodeIn(skuCode)
        .stream()
        .map(inventory -> InventoryResponse.builder()
            .skuCode(inventory.getSkuCode())
            .isInStock(inventory.getQuantity() > 0)
            .build())
        .toList();
  }
}
