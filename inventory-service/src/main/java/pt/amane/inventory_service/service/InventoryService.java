package pt.amane.inventory_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import pt.amane.inventory_service.dto.InventoryResponse;

@Service
public interface InventoryService {

  List<InventoryResponse> isInStock(List<String> skuCode);

}
