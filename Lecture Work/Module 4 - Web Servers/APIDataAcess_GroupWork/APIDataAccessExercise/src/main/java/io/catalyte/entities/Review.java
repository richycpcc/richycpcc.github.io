package io.catalyte.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.ValueGenerationType;
import io.catalyte.entities.Vehicle;


import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Review")
public class Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer rating;
    private String date;
    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="vehicle_id")
    //@NotNull(message="Vehicle is Required")
    private Vehicle vehicle;

    public Review(){}

    //Constructor
    public Review(String title, String description, Integer rating, String date, String username) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.date = date;
        this.username = username;


    }
    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
