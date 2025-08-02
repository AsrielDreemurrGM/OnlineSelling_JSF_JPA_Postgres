package br.com.eaugusto.service;

import java.util.List;

import br.com.eaugusto.model.Product;
import br.com.eaugusto.repository.ProductRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class ProductService {

    @Inject
    private ProductRepository repository;

    @Transactional
    public void save(Product product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new IllegalArgumentException("Product name is required.");
        }

        if (product.getPrice() == null || product.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }

        repository.save(product);
    }

    @Transactional
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(id);
    }

    @Transactional
    public Product findById(Long id) {
        return repository.findById(id);
    }

    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }
}
