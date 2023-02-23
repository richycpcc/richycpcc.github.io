package io.catalyte.springboot.services;


import io.catalyte.springboot.entities.Users;

import java.util.List;


public interface UsersService {
    List<Users> GetAllUsers(Users users);

    Users GetUserById(Long id);

    Users AddUser(Users users);

    Users UpdateUserById(Long id, Users users);

    void DeleteUserById(Long id);


}
