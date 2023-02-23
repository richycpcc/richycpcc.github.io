package io.catalyte.springboot.controllers;

import io.catalyte.springboot.entities.Users;
import io.catalyte.springboot.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static io.catalyte.springboot.constants.StringConstants.LOGGER_DELETE_REQUEST_RECEIVED;
import static io.catalyte.springboot.constants.StringConstants.LOGGER_POST_REQUEST_RECEIVED;
import static io.catalyte.springboot.constants.StringConstants.LOGGER_PUT_REQUEST_RECEIVED;
import static io.catalyte.springboot.constants.StringConstants.LOGGER_REQUEST_RECEIVED;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value= "/users")
public class UsersController {
    private final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(Users users)
    {
        logger.info(new Date() + LOGGER_REQUEST_RECEIVED);

        return new ResponseEntity<>(usersService.GetAllUsers(users),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id")Long id)
    {
        logger.info(new Date() + LOGGER_REQUEST_RECEIVED + id);
        return new ResponseEntity<>(usersService.GetUserById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id)
    {
        logger.info(new Date() + " Delete request received for id: " + id);
        usersService.DeleteUserById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Users> updateUserById(@PathVariable Long id, @Valid @RequestBody Users users)
    {
        logger.info(new Date() + " Update request received for id: " + id);
        return new ResponseEntity<>(usersService.UpdateUserById(id, users),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Users> save(@Valid @RequestBody Users users)
    {
        logger.info(new Date() + " Post request received " + users.toString());
        return new ResponseEntity<>(usersService.AddUser(users), HttpStatus.CREATED);
    }








//    @Autowired
//    private UsersService usersService;
//    public List<Users> usersList = new ArrayList<>();
//    Optional<Users> userById;
//
//    @GetMapping
//    public List<Users> getAllUsers(){
//        usersList = usersService.GetUsers();
//        return usersList;
//    }
//
//    @GetMapping(path = "{id}")
//    public Optional<Users> getUserById(@PathVariable("id") Long id){
//        userById = usersService.GetUsersById(id);
//        return userById;
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addUsers(@RequestBody Users users){usersService.AddUser(users);}
//
//    @PutMapping(path = "{id}")
//    public void updateUsers(@PathVariable("id")Long id, @RequestBody Users users){
//        usersService.UpdateUser(users);
//    }
//
//    @DeleteMapping("/delete")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteUsersById(@RequestParam Long id){usersService.DeleteUserById(id);}


} // end class
