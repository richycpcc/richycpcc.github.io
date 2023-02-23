package io.catalyte.springboot.entities;

import jakarta.persistence.*;
import io.catalyte.springboot.entities.Customers;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="add_id")
    private Long id;


    private String street;
    private String city;
    //@Size(min =2, max = 2)
    @Pattern(regexp="^[a-zA-Z]{2}", message = "State does not fit format: XX")
    private String state; //needs valid 2 letter US state abbreviation
    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "Zip Code does not fit format: xxxxx or xxxxx-xxxx")//https://howtodoinjava.com/java/regex/us-postal-zip-code-validation/
    private String zipCode; //XXXXX or XXXXX-XXXX format



    public Address(){

    }


    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode= zipCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, state, zipCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
