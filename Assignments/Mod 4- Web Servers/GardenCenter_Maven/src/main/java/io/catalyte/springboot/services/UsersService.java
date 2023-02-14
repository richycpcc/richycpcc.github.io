package io.catalyte.springboot.services;

import io.catalyte.springboot.entities.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<Users> GetUsers();

    Optional<Users> GetUsersById(Long id);

    void AddUser(Users users);

    void UpdateUser(Users users);

    void DeleteUserById(Long id);
}
