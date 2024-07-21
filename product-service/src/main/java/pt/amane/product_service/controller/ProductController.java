package pt.amane.product_service.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import pt.amane.product_service.controller.definition.ProductDefinition;
import pt.amane.product_service.dto.ProductRequest;
import pt.amane.product_service.dto.ProductRsaponse;
import pt.amane.product_service.service.ProductService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController implements ProductDefinition {

  private final ProductService productService;

  @Override
  public void createProduct(ProductRequest productRequest) {
    log.info("Product Request {}", productRequest);
    productService.createProduct(productRequest);
  }

  @Override
  public List<ProductRsaponse> getAllProducts() {
    return productService.getAllProducts();
  }
}
