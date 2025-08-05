package br.com.eaugusto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

/**
 * JPA entity that represents a product in the system.
 * Maps to a relational table and stores product-related data.
 *
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM)
 * @since Aug 1, 2025
 */
@Entity
public class Product {

    /**
     * Unique identifier for the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Product name. Cannot be null.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Product description (optional).
     */
    private String description;

    /**
     * Product price.
     */
    private Double price;

    /**
     * Quantity of the product in stock.
     */
    private Integer stock;

    /**
     * Default constructor.
     */
    public Product() {
    }

    /**
     * Constructor with all fields (except ID).
     *
     * @param name        Product name.
     * @param description Product description.
     * @param price       Product price.
     * @param stock       Quantity in stock.
     */
    public Product(String name, String description, Double price, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
