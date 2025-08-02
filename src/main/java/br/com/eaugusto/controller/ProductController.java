package br.com.eaugusto.controller;

import br.com.eaugusto.model.Product;
import br.com.eaugusto.service.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("productController")
@ViewScoped
public class ProductController implements Serializable {
    private static final long serialVersionUID = 1L;

    private Product product;
    private List<Product> products;
    private String searchTerm;

    @Inject
    private ProductService productService;

    @PostConstruct
    public void init() {
        product = new Product();
        products = productService.findAll();
    }

    public Product getProduct() {
        return product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String save() {
        productService.save(product);
        products = productService.findAll();
        product = new Product();
        return "productForm.xhtml";
    }

    public String edit(Long id) {
        this.product = productService.findById(id);
        if (this.product == null) {
            this.product = new Product();
        }
        return "productForm.xhtml";
    }

    public String delete(Long id) {
        productService.delete(id);
        return "productForm.xhtml";
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String search() {
        if (searchTerm == null || searchTerm.isBlank()) {
            products = productService.findAll();
        } else {
            products = productService.findByName(searchTerm);
        }
        return null;
    }

    public String clear() {
        this.product = new Product();
        return "productForm.xhtml";
    }
}
