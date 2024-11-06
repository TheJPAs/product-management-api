package the.jpas.product.management.api.services;

import salesiana.university.productsmanagementapi.entities.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductService {
  List<Product> findAllProducts();
  Optional<Product> findProductById(UUID productId);
  Product createProduct(Product product);
  Product updateProduct(UUID productId, Product product);
  boolean deleteProduct(UUID productId);
}
