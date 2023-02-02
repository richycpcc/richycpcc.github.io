package io.catalyte.entities;

import jakarta.persistence.*;


import javax.validation.constraints.NotNull;

@Entity
class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @NotNull(message = "Game is Required")
    private Game game;
    public Player(){

    }

    public Player(Long id, String firstName, String lastName, Integer age, @NotNull(message = "Game is Required") Game game)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
