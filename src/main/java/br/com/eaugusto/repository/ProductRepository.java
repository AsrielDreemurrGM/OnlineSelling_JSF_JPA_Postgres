package br.com.eaugusto.repository;

import br.com.eaugusto.model.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

/**
 * Repository class that provides direct access to the database using JPA.
 * Handles all product-related persistence operations.
 *
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM)
 * @since Aug 2, 2025
 */
@ApplicationScoped
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * Saves a product to the database.
     * Performs insert if the product is new, or update otherwise.
     *
     * @param product The product to persist.
     */
    public void save(Product product) {
        if (product.getId() == null) {
            em.persist(product);
        } else {
            em.merge(product);
        }
    }

    /**
     * Retrieves all products from the database.
     *
     * @return List of all products.
     */
    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     */
    public void delete(Long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    /**
     * Finds a product by its ID.
     *
     * @param id The ID of the product.
     * @return The product, or null if not found.
     */
    public Product findById(Long id) {
        if (id == null)
            return null;
        return em.find(Product.class, id);
    }

    /**
     * Finds products by partial name match (case-insensitive).
     *
     * @param name The name fragment to search.
     * @return List of matching products.
     */
    public List<Product> findByName(String name) {
        return em.createQuery("SELECT p FROM Product p WHERE LOWER(p.name) LIKE :name", Product.class)
                .setParameter("name", "%" + name.toLowerCase() + "%")
                .getResultList();
    }
}
