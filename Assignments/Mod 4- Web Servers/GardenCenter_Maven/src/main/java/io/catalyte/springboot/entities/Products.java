package io.catalyte.springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String type;
    private String name;
    private String description;
    private String manufacturer;
    private BigDecimal price;

    public Products(){

    }
    public Products(String sku, String type, String name, String description, String manufacturer, BigDecimal price) {
        this.sku = sku;
        this.type = type;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products products)) return false;
        return Objects.equals(id, products.id) && Objects.equals(sku, products.sku) && Objects.equals(type, products.type) && Objects.equals(name, products.name) && Objects.equals(description, products.description) && Objects.equals(manufacturer, products.manufacturer) && Objects.equals(price, products.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sku, type, name, description, manufacturer, price);
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }
}
