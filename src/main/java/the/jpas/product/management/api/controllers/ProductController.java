package the.jpas.product.management.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salesiana.university.productsmanagementapi.entities.Product;
import salesiana.university.productsmanagementapi.services.IProductService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
  private final IProductService productService;

  public ProductController(IProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products")
  public ResponseEntity<?> findAllProducts() {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.findAllProducts());
  }

  @GetMapping("/products/{productId}")
  public ResponseEntity<?> findProductById(@PathVariable("productId")UUID productId) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.findProductById(productId).get());
  }

  @PostMapping("/saveProduct")
  public ResponseEntity<?> saveProduct(@RequestBody Product product) {
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(productService.createProduct(product));
  }

  @PutMapping("/updateProduct/{productId}")
  public ResponseEntity<?> updateProduct(@PathVariable("productId") UUID productId, @RequestBody Product product) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.updateProduct(productId, product));
  }

  @DeleteMapping("/deleteProduct/{productId}")
  public ResponseEntity<?> deleteProduct(@PathVariable("productId") UUID productId) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.deleteProduct(productId));
  }
}
