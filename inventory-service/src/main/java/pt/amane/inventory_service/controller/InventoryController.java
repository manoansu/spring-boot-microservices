package pt.amane.inventory_service.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pt.amane.inventory_service.controller.definition.InventoryDefinition;
import pt.amane.inventory_service.dto.InventoryResponse;
import pt.amane.inventory_service.service.InventoryService;

@RestController
@RequiredArgsConstructor
public class InventoryController implements InventoryDefinition {

  private final InventoryService inventoryService;

  @Override
  public List<InventoryResponse> isInStock(List<String> skuCode) {
    return inventoryService.isInStock(skuCode);
  }
}
