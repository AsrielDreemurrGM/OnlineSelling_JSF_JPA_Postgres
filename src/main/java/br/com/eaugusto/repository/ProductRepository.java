package br.com.eaugusto.repository;

import br.com.eaugusto.model.Product;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

@ApplicationScoped
public class ProductRepository {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("online_selling");

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void save(Product product) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            if (product.getId() == null) {
                em.persist(product);
            } else {
                em.merge(product);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Product> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Product p", Product.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Product product = em.find(Product.class, id);
            if (product != null) {
                em.remove(product);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Product findById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    public List<Product> findByName(String name) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Product p WHERE LOWER(p.name) LIKE :name", Product.class)
                    .setParameter("name", "%" + name.toLowerCase() + "%")
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
