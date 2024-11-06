package the.jpas.product.management.api.services;

import org.springframework.stereotype.Service;
import salesiana.university.productsmanagementapi.entities.Product;
import salesiana.university.productsmanagementapi.repositories.IProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements IProductService {
  private final IProductRepository productRepository;

  public ProductService(IProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> findProductById(UUID productId) {
    return productRepository.findById(productId);
  }

  @Override
  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product updateProduct(UUID productId, Product product) {
    Optional<Product> productOptional = productRepository.findById(productId);
    Product productToUpdate = productOptional.get();
    productToUpdate.setName(product.getName());
    productToUpdate.setDescription(product.getDescription());
    productToUpdate.setPrice(product.getPrice());
    return productRepository.save(productToUpdate);
  }

  @Override
  public boolean deleteProduct(UUID productId) {
    Optional<Product> productOptional = productRepository.findById(productId);

    if (productOptional.isEmpty()) {
      return false;
    }
    productRepository.delete(productOptional.get());
    return true;
  }
}
