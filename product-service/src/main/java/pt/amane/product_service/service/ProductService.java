package pt.amane.product_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import pt.amane.product_service.dto.ProductRequest;
import pt.amane.product_service.dto.ProductRsaponse;

@Service
public interface ProductService {

  void createProduct(ProductRequest productRequest);

  List<ProductRsaponse> getAllProducts();
}
