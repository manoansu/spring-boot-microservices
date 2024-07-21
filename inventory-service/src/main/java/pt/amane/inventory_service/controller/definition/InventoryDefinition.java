package pt.amane.inventory_service.controller.definition;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import pt.amane.inventory_service.dto.InventoryResponse;

@RequestMapping("/api/inventory")
public interface InventoryDefinition {

  //http://localhost:8082/api/inventory/iphone-13

  //http://localhost:8082/api/inventory?sku-code=iphone-13&sku-code=iphone-13-red
  @GetMapping("/{sku-code}")
  @ResponseStatus(HttpStatus.OK)
  List<InventoryResponse> isInStock(@PathVariable("sku-code") List<String> skuCode);

}
