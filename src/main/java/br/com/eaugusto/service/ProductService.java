package br.com.eaugusto.service;

import java.util.List;

import br.com.eaugusto.model.Product;
import br.com.eaugusto.repository.ProductRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

/**
 * Service layer responsible for applying business rules to product operations.
 * Acts as an intermediary between the controller and the repository.
 *
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM)
 * @since Aug 2, 2025
 */
@RequestScoped
public class ProductService {

    @Inject
    private ProductRepository repository;

    /**
     * Saves a product to the database. Applies validation rules:
     * - Name must not be blank;
     * - Price must be greater than 0.
     *
     * @param product The product to save.
     * @throws IllegalArgumentException if validation fails.
     */
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

    /**
     * Retrieves all products from the database.
     *
     * @return List of all products.
     */
    @Transactional
    public List<Product> findAll() {
        return repository.findAll();
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     */
    @Transactional
    public void delete(Long id) {
        repository.delete(id);
    }

    /**
     * Finds a product by its ID.
     *
     * @param id The product ID.
     * @return The product, or null if not found.
     */
    @Transactional
    public Product findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Searches for products whose names contain the given text (case-insensitive).
     *
     * @param name The search text.
     * @return List of matching products.
     */
    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }
}
