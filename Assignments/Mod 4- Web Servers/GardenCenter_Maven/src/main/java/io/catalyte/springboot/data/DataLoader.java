package io.catalyte.springboot.data;

import io.catalyte.springboot.entities.Users;
import io.catalyte.springboot.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class DataLoader implements CommandLineRunner {
    private Users users;
    @Autowired
    private UsersRepository usersRepository;


    private Users user1;
    private Users user2;
    private Users user3;

    @Override
    public void run(String... args) throws Exception{
        loadUsers();
    }

    private void loadUsers(){
        user1 = usersRepository.save(new Users("Harry Potter","CEO", "admin","hp@test.com", "Password1!"));
        user2 = usersRepository.save(new Users("Ron Weasley","CFO", "employee", "rw@test.com", "Password1!"));
        user3 = usersRepository.save(new Users("Hermione Granger","CIO", "admin", "hg@test.com", "Password1!"));
    }
}