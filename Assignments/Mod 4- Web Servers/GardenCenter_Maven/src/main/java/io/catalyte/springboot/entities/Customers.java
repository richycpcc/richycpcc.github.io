package io.catalyte.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id; //One customer to Many Orders
    private String name;
    @Pattern(message = "Email is not valid", regexp = "^[A-Za-z0-9+_.-]+@(.+)$")//https://howtodoinjava.com/java/regex/java-regex-validate-email-address/ https://stackoverflow.com/questions/65370879/javax-validation-constraints-email-in-springboot
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "fk_add_id")
    private Address address;

    @OneToMany(cascade = CascadeType.REMOVE) //https://www.youtube.com/watch?v=2fvUrpYG95w&t=211s
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JoinColumn(name="fk_customer_id",referencedColumnName = "customer_id")
    private List<Orders> orders;

    public Customers(){

    }
//    public Customers(Long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }

    public Customers(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customers customers)) return false;
        return Objects.equals(id, customers.id) && Objects.equals(name, customers.name) && Objects.equals(email, customers.email) && Objects.equals(address, customers.address) && Objects.equals(orders, customers.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, address, orders);
    }
}
