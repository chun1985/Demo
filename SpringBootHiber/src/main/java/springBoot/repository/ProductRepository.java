
package springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);
}
