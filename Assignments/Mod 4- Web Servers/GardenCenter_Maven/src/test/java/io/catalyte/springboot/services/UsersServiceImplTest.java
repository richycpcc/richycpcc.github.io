package io.catalyte.springboot.services;

import io.catalyte.springboot.entities.Users;
import io.catalyte.springboot.exceptions.BadDataResponse;
import io.catalyte.springboot.exceptions.Conflict;
import io.catalyte.springboot.exceptions.ResourceNotFound;
import io.catalyte.springboot.exceptions.ServiceUnavailable;
import io.catalyte.springboot.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;

import static org.mockito.ArgumentMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsersServiceImplTest {
    @Mock
    UsersRepository usersRepository;
    @Mock
    UsersService usersService;
    @InjectMocks
    UsersServiceImpl usersServiceImpl;

    //variables for expected results
    Users testUsers;
    List<Users> testList = new ArrayList<>();


    @BeforeEach
    @SuppressWarnings("unchecked")
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        testUsers = new Users("Richy Boy", "Tester", List.of("employee"),"rb@email.com","Password1!");
        testUsers.setId(1L);
        testList.add(testUsers);


        when(usersRepository.findById(any(Long.class))).thenReturn(Optional.of(testList.get(0)));
        when(usersRepository.saveAll(anyCollection())).thenReturn(testList);
        when(usersRepository.save(any(Users.class))).thenReturn(testList.get(0));
        when(usersRepository.findAll()).thenReturn(testList);
        when(usersRepository.findAll(any(Example.class))).thenReturn(testList);

    }


    @Test
    public void getAllUsers() {
        List<Users> result = usersServiceImpl.GetAllUsers(new Users());
        assertEquals(testList, result);
    }
    @Test
    public void getAllUsersWithSample() {
        List<Users> result = usersServiceImpl.GetAllUsers(testUsers);
        assertEquals(testList, result);
    }
    @Test
    public void getAllUserByIdDBError() {
        when(usersRepository.findAll(any(Example.class))).thenThrow(EmptyResultDataAccessException.class);
        assertThrows(ServiceUnavailable.class,
                () -> usersServiceImpl.GetAllUsers(testUsers));
    }

//    @Test
//    public void getAllUsersDBError() {
//        // set repo to trigger Data Access Exception
//        when(usersRepository.findAll()).thenThrow(EmptyResultDataAccessException.class);
//
//        assertThrows(ServiceUnavailable.class,
//                () -> usersServiceImpl.GetAllUsers(new Users()));
//    }


    @Test
    public void getUserById() {
        Users result = usersServiceImpl.GetUserById(1L);
        assertEquals(testUsers, result);
    }

    @Test
    public void getUserByIdNotFound() {
        when(usersRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(ResourceNotFound.class,
                () -> usersServiceImpl.GetUserById(1L));
        String expectedMessage = "Could not locate a User with the id: 1";
        assertEquals(expectedMessage,
                exception.getMessage(),
                () -> "Message did not equal '" + expectedMessage + "', actual message:"
                        + exception.getMessage());
    }
    @Test
    public void getUserByIdDBError() {
        when(usersRepository.findById(anyLong())).thenThrow(EmptyResultDataAccessException.class);
        assertThrows(ServiceUnavailable.class,
                () -> usersServiceImpl.GetUserById(1L));
    }

    @Test
    public void deleteUserById() {
        when(usersRepository.existsById(anyLong())).thenReturn(true);
        usersServiceImpl.DeleteUserById(1L);
        verify(usersRepository).deleteById(any());
    }

    @Test
    public void deleteUserBadID() {
        doThrow(new ResourceNotFound("Could not locate a User with the id")).when(usersRepository)
                .deleteById(anyLong());
        assertThrows(ResourceNotFound.class,
                () -> usersServiceImpl.DeleteUserById(1L));
    }
    @Test
    public void deleteUserDBError() {
        doThrow(new ServiceUnavailable("Database unavailable")).when(usersRepository)
                .existsById(anyLong());
        assertThrows(ServiceUnavailable.class,
                () -> usersServiceImpl.DeleteUserById(1L));
    }


    @Test
    public void updateUserById() {
        Users result = usersServiceImpl.UpdateUserById(1L, testUsers);
        assertEquals(testUsers, result);
    }
    @Test
    public void updateUsersByIdNotFound() {
        when(usersRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFound.class,
                () -> usersServiceImpl.UpdateUserById(1L, testUsers));
        String expectedMessage = "Could not locate a Users with the id: 1";
        assertEquals(expectedMessage,
                exception.getMessage(),
                () -> "Message did not equal '" + expectedMessage + "', actual message:"
                        + exception.getMessage());
    }


    @Test
    public void updateUsersByIdBadData() {
        Exception exception = assertThrows(BadDataResponse.class,
                () -> usersServiceImpl.UpdateUserById(2L, testUsers));
        String expectedMessage = "User ID must match the ID specified in the URL";
        assertEquals(expectedMessage,
                exception.getMessage(),
                () -> "Message did not equal '" + expectedMessage + "', actual message:"
                        + exception.getMessage());
    }
    @Test
    public void updateUserByIdDBError() {
        when(usersRepository.findById(anyLong())).thenThrow(EmptyResultDataAccessException.class);
        assertThrows(ServiceUnavailable.class,
                () -> usersServiceImpl.UpdateUserById(1L, testUsers));
    }

    @Test
    public void addUser() {
        Users result = usersServiceImpl.addUser(testUsers);
        assertEquals(testUsers, result);
    }
    @Test
    public void addUserEmailConflict(){
        when(usersRepository.existsByEmail(any(String.class))).thenReturn(true);
        assertThrows(Conflict.class,() -> usersServiceImpl.addUser(testUsers));
    }

    @Test
    public void addUsersDBError() {
        when(usersRepository.save(any(Users.class))).thenThrow(
                new EmptyResultDataAccessException("Database unavailable", 0));
        assertThrows(ServiceUnavailable.class,
                () -> usersServiceImpl.addUser(testUsers));
    }


}