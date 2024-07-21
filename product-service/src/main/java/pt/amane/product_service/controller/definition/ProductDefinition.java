package pt.amane.product_service.controller.definition;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import pt.amane.product_service.dto.ProductRequest;
import pt.amane.product_service.dto.ProductRsaponse;

@RequestMapping("/api/product")
public interface ProductDefinition {

  @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
  void createProduct(@RequestBody ProductRequest productRequest);

  @GetMapping
  List<ProductRsaponse> getAllProducts();

}
