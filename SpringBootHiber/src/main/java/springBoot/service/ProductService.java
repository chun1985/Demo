
package springBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.entity.Product;
import springBoot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public Product getProductByName(String name) {
		return repository.findByName(name);
	}

	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed";
	}

	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
}
