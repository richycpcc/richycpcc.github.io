package io.catalyte.springboot.controllers;

import io.catalyte.springboot.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.catalyte.springboot.entities.Users;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    public List<Users> usersList = new ArrayList<>();
    Optional<Users> userById;

    @GetMapping
    public List<Users> getAllUsers(){
        usersList = usersService.GetUsers();
        return usersList;
    }

    @GetMapping(path = "{id}")
    public Optional<Users> getUserById(@PathVariable("id") Long id){
        userById = usersService.GetUsersById(id);
        return userById;
    }

    @PostMapping //Postman request isn't working
    @ResponseStatus(HttpStatus.CREATED)
    public void addUsers(@RequestBody Users users){usersService.AddUser(users);}

    @PutMapping(path = "{id}")
    public void updateUsers(@PathVariable("id")Long id, @RequestBody Users users){
        usersService.UpdateUser(users);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsersById(@RequestParam Long id){usersService.DeleteUserById(id);}


} // end class
