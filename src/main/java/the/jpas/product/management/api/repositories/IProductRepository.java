package the.jpas.product.management.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salesiana.university.productsmanagementapi.entities.Product;

import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {
}
