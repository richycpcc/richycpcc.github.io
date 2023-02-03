package io.catalyte.springboot.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int rating;
    private String date;
    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Vehicle vehicle;


    public Review() {
    }

    public Review(String title, String description, int rating, String date, String username, Long vehicle_id) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.date = date;
        this.username = username;
//        this.vehicle_id = vehicle_id;
    }

    public Review(String title, String description, int rating, String date, String username) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.date = date;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    //    public Review(Long id, String title, String description, int rating, String date, String username, Long vehicleId) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.rating = rating;
//        this.date = date;
//        this.username = username;
//        this.vehicleId = vehicleId;
//
//
//    }
}
