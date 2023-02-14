package io.catalyte.springboot.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
//@Table(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String title;
    private String roles; // Needs to be Array of roles
    private List<String> role = new ArrayList<>();
    private String email; //"email format"
    private String password; //8 char min

    public Users() {
    }

   // List<String> role = new ArrayList<>();
    public Users( String name, String title, String roles, String email, String password) {
        this.name = name;
        this.title = title;
        this.roles = roles;
        this.email = email;
        this.password = password;
    }

    public Users(String name, String title, String roles, List<String> role, String email, String password) {
        this.name = name;
        this.title = title;
        this.roles = roles;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public Users(long id, String name, String title, String roles, String email, String password) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.roles = roles;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles (String roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
} //end class