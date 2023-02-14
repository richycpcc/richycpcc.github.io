package io.catalyte.springboot.services;

import io.catalyte.springboot.entities.Users;
import io.catalyte.springboot.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    private Users users;
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository){this.usersRepository = usersRepository;}

    List<Users> usersList = new ArrayList<>();
    Optional<Users> userByID;

    @Override
    public List<Users> GetUsers() {
        try{
            usersList = usersRepository.findAll();
            return usersList;
        }catch (DataAccessException dae){
            throw new IllegalAccessError();
        }
    }
    @Override
    public Optional<Users> GetUsersById(Long id) {
        try{
            userByID = usersRepository.findById(id);
            return userByID;
        }catch (DataAccessException dae){
            throw new IllegalAccessError();
        }
    }
    @Override
    public void AddUser(Users users) {
        try {
            usersRepository.save(users);
        } catch (DataAccessException dae) {
            throw new IllegalAccessError();
        }
    }

    @Override
    public void UpdateUser(Users users){
        try{
            usersRepository.save(users);
        }catch (DataAccessException dae) {
            throw new IllegalAccessError();
        }
    }

    @Override
    public void DeleteUserById(Long id) {
        boolean exists = usersRepository.existsById(id);
        if (!exists){
            throw new IllegalAccessError();
        }
        usersRepository.deleteById(id);
    }





} // end class
