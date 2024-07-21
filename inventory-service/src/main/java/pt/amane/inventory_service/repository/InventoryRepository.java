package pt.amane.inventory_service.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pt.amane.inventory_service.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

  List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
