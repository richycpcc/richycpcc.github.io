package io.catalyte.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Vehicle")
public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String type;
    private String make;
    private String model;
    private Integer year;
    @OneToMany(mappedBy = "vehicle",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();
    //I got this from this video https://www.youtube.com/watch?v=8X1eaC6r2TM

    //Public declaration of class
    public Vehicle(){}

    public Vehicle(String model) {
        this.model = model;
    }

    //Constructor
    public Vehicle( Long id,String type, String make, String model, Integer year)
    {
        this.id = id;
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters and Setters
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public String getMake() {return make;}

    public void setMake(String make) {this.make = make;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public Integer getYear() {return year;}

    public void setYear(Integer year) {this.year = year;}
}
