package br.com.eaugusto.repository;

import br.com.eaugusto.model.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Product product) {
        if (product.getId() == null) {
            em.persist(product);
        } else {
            em.merge(product);
        }
    }

    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public void delete(Long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    public Product findById(Long id) {
        if (id == null)
            return null;
        return em.find(Product.class, id);
    }

    public List<Product> findByName(String name) {
        return em.createQuery("SELECT p FROM Product p WHERE LOWER(p.name) LIKE :name", Product.class)
                .setParameter("name", "%" + name.toLowerCase() + "%")
                .getResultList();
    }
}
