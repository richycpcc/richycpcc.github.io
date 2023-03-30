package io.catalyte.springboot.entities;


import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;

    private List<String> roles;
    @Email(message = "Email is invalid")// regexp = "^[A-Za-z0-9+_.-]+@(.+)$")//https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
    private String email; //"email format"
    @Size(min = 8, max = 25, message = "Password must be at least 8 characters long") //validation info https://www.baeldung.com/spring-boot-bean-validation
    private String password; //8 char min

    public Users() {
    }

    //https://www.baeldung.com/java-email-validation-regex
//    public static boolean patternMatches(String email, String regexPattern){
//        return Pattern.compile(regexPattern)
//                .matcher(email)
//                .matches();
//    }
   // List<String> role = new ArrayList<>();


//    public Users(Long id, String name, String title, List<String> roles, String email, String password) {
//        this.id = id;
//        this.name = name;
//        this.title = title;
//        this.roles = roles;
//        this.email = email;
//        this.password = password;
//    }

    public Users(String name, String title, List<String> roles, String email, String password) {
        this.name = name;
        this.title = title;
        this.roles = roles;
        this.email = email;
        this.password = password;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Users users)) return false;
//        return Objects.equals(id, users.id) && Objects.equals(name, users.name) && Objects.equals(title, users.title) && Objects.equals(roles, users.roles) && Objects.equals(email, users.email) && Objects.equals(password, users.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, title, roles, email, password);
//    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", roles=" + roles +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
} //end class