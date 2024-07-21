package pt.amane.product_service.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import pt.amane.product_service.dto.ProductRequest;
import pt.amane.product_service.dto.ProductRsaponse;
import pt.amane.product_service.model.Product;


public class ProductServiceUtils {


  public static List<ProductRsaponse> getAllproducts() {
    List<Product> products = Arrays.asList(getProduct());
    return products.stream()
        .map(product -> mapToProductResponse(product)).toList();
  }

  public static ProductRsaponse mapToProductResponse(Product product) {
    return ProductRsaponse.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .build();
  }

  public static ProductRequest getProductRequest() {
    return ProductRequest.builder()
        .name("iphone 13")
        .description("iphone 13")
        .price(BigDecimal.valueOf(1200))
        .build();
  }

  public static Product getProduct() {
    return Product.builder()
        .name("iphone 13")
        .description("iphone 13")
        .price(BigDecimal.valueOf(1200))
        .build();
  }

}
