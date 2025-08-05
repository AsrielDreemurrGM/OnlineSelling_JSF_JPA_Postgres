package br.com.eaugusto.controller;

import br.com.eaugusto.model.Product;
import br.com.eaugusto.service.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

/**
 * Controller responsible for handling user interactions on the product page.
 * It connects the JSF view with the business logic and data persistence layers.
 * Manages product creation, searching, and deletion.
 *
 * Scope: ViewScoped - the controller lives as long as the user is on the same
 * JSF view.
 *
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM)
 * @since Aug 2, 2025
 */
@Named("productController")
@ViewScoped
public class ProductController implements Serializable {
    private static final long serialVersionUID = 1L;

    private Product product;
    private List<Product> products;
    private String searchTerm;

    @Inject
    private ProductService productService;

    /**
     * Initializes the controller by creating a new product instance
     * and loading all products from the database.
     */
    @PostConstruct
    public void init() {
        product = new Product();
        products = productService.findAll();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() {
        return products;
    }

    /**
     * Persists the current product and reloads the product list.
     *
     * @return null to stay on the same page.
     */
    public String save() {
        productService.save(product);
        products = productService.findAll();
        product = new Product();
        return null;
    }

    public void edit() {
    }

    /**
     * Deletes a product by its ID and refreshes the product list.
     *
     * @param id The ID of the product to delete.
     * @return null to stay on the same page.
     */
    public String delete(Long id) {
        productService.delete(id);
        products = productService.findAll();
        return null;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * Searches for products by the search term. If empty, returns all products.
     *
     * @return null to stay on the same page.
     */
    public String search() {
        if (searchTerm == null || searchTerm.isBlank()) {
            products = productService.findAll();
        } else {
            products = productService.findByName(searchTerm);
        }
        return null;
    }

    /**
     * Clears the current product instance (used when resetting the form).
     *
     * @return null to stay on the same page.
     */
    public String clear() {
        product = new Product();
        return null;
    }
}
