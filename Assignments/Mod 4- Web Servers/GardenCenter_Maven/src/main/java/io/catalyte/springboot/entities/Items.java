package io.catalyte.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import javax.validation.constraints.Min;
import java.util.Objects;
import java.util.List;

@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0)
    private Integer quantity;
//    @OneToOne
//    private Products products; //many products to many items?
    private Long productId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="order_id")
    @JsonIgnore
    private Orders orders; //

    public Items(){

    }

//    public Items(Long id, Integer quantity, Orders orders) {
//        this.id = id;
//        this.quantity = quantity;
//        this.orders = orders;
//    }

//    public Items(Integer quantity, Products products, Orders orders) {
//        this.quantity = quantity;
//        this.products = products;
//        this.orders = orders;
//    }


    public Items(Long productId,Integer quantity,  Orders orders) {
        this.productId = productId;
        this.quantity = quantity;
        this.orders = orders;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Items items)) return false;
        return Objects.equals(id, items.id) && Objects.equals(quantity, items.quantity) && Objects.equals(productId, items.productId) && Objects.equals(orders, items.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, productId, orders);
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", productId=" + productId +
                ", orders=" + orders +
                '}';
    }
}
