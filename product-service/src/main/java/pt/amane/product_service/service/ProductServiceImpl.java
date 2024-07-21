package pt.amane.product_service.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pt.amane.product_service.dto.ProductRequest;
import pt.amane.product_service.dto.ProductRsaponse;
import pt.amane.product_service.model.Product;
import pt.amane.product_service.repository.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public void createProduct(ProductRequest productRequest) {

    Product product = Product.builder()
        .name(productRequest.getName())
        .description(productRequest.getDescription())
        .price(productRequest.getPrice())
        .build();

    productRepository.save(product);

    log.info("Product {} is saved successful", product.getId());
  }

  @Override
  public List<ProductRsaponse> getAllProducts() {
    List<Product> products = productRepository.findAll();
   return products.stream()
       .map(product -> mapToProductResponse(product)).toList();
  }

  private ProductRsaponse mapToProductResponse(Product product) {
    return ProductRsaponse.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .build();
  }


}
