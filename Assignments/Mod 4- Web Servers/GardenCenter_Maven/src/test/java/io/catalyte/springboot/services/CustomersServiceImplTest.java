package io.catalyte.springboot.services;

import io.catalyte.springboot.entities.Address;
import io.catalyte.springboot.entities.Customers;
import io.catalyte.springboot.exceptions.BadDataResponse;
import io.catalyte.springboot.exceptions.Conflict;
import io.catalyte.springboot.exceptions.ResourceNotFound;
import io.catalyte.springboot.exceptions.ServiceUnavailable;
import io.catalyte.springboot.repositories.CustomersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class CustomersServiceImplTest {

        @Mock
        CustomersRepository customersRepository;
        @Mock
        CustomersService customersService;
        @InjectMocks
        CustomersServiceImpl customersServiceImpl;

        //variables for expected results
        Customers testCustomers;
        List<Customers> testList = new ArrayList<>();


        @BeforeEach
        @SuppressWarnings("unchecked")
        public void setUp(){
            MockitoAnnotations.openMocks(this);
            testCustomers = new Customers("Richy Phongsavath","rp@test.org",new Address("123 Street","Charlotte","NC","12345"));
            testCustomers.setId(1L);
            testList.add(testCustomers);


            when(customersRepository.findById(any(Long.class))).thenReturn(Optional.of(testList.get(0)));
            when(customersRepository.saveAll(anyCollection())).thenReturn(testList);
            when(customersRepository.save(any(Customers.class))).thenReturn(testList.get(0));
            when(customersRepository.findAll()).thenReturn(testList);
            when(customersRepository.findAll(any(Example.class))).thenReturn(testList);

        }


        @Test
        public void getAllCustomers() {
            List<Customers> result = customersServiceImpl.GetAllCustomers(new Customers());
            assertEquals(testList, result);
        }
        @Test
        public void getAllCustomersWithSample() {
            List<Customers> result = customersServiceImpl.GetAllCustomers(testCustomers);
            assertEquals(testList, result);
        }
        @Test
        public void getAllCustomersByIdDBError() {
            when(customersRepository.findAll(any(Example.class))).thenThrow(EmptyResultDataAccessException.class);
            assertThrows(ServiceUnavailable.class,
                    () -> customersServiceImpl.GetAllCustomers(testCustomers));
        }

        @Test
        public void getCustomerById() {
            Customers result = customersServiceImpl.GetCustomerById(1L);
            assertEquals(testCustomers, result);
        }

        @Test
        public void getCustomerByIdNotFound() {
            when(customersRepository.findById(anyLong())).thenReturn(Optional.empty());
            Exception exception = assertThrows(ResourceNotFound.class,
                    () -> customersServiceImpl.GetCustomerById(1L));
            String expectedMessage = "Could not locate a Customer with the id: 1";
            assertEquals(expectedMessage,
                    exception.getMessage(),
                    () -> "Message did not equal '" + expectedMessage + "', actual message:"
                            + exception.getMessage());
        }
        @Test
        public void getCustomerByIdDBError() {
            when(customersRepository.findById(anyLong())).thenThrow(EmptyResultDataAccessException.class);
            assertThrows(ServiceUnavailable.class,
                    () -> customersServiceImpl.GetCustomerById(1L));
        }

        @Test
        public void deleteCustomerById() {
            when (customersRepository.existsById(anyLong())).thenReturn(true);
            customersServiceImpl.DeleteCustomersById(1L);
            verify(customersRepository).deleteById(any());
        }

        @Test
        public void deleteUserBadID() {
            doThrow(new ResourceNotFound("Could not locate a User with the id")).when(customersRepository)
                    .deleteById(anyLong());
            assertThrows(ResourceNotFound.class,
                    () -> customersServiceImpl.DeleteCustomersById(1L));
        }
        @Test
        public void deleteUserDBError() {
            doThrow(new ServiceUnavailable("Database unavailable")).when(customersRepository)
                    .existsById(anyLong());
            assertThrows(ServiceUnavailable.class,
                    () -> customersServiceImpl.DeleteCustomersById(1L));
        }


        @Test
        public void UpdateCustomersById() {
            Customers result = customersServiceImpl.UpdateCustomerById(1L, testCustomers);
            assertEquals(testCustomers, result);
        }
        @Test
        public void updateUsersByIdNotFound() {
            when(customersRepository.findById(anyLong())).thenReturn(Optional.empty());

            Exception exception = assertThrows(ResourceNotFound.class,
                    () -> customersServiceImpl.UpdateCustomerById(1L, testCustomers));
            String expectedMessage = "Could not locate a Customer with the id: 1";
            assertEquals(expectedMessage,
                    exception.getMessage(),
                    () -> "Message did not equal '" + expectedMessage + "', actual message:"
                            + exception.getMessage());
        }

        @Test
        public void updateUsersByIdBadData() {
            Exception exception = assertThrows(BadDataResponse.class,
                    () -> customersServiceImpl.UpdateCustomerById(2L, testCustomers));
            String expectedMessage = "Customer ID must match the ID specified in the URL";
            assertEquals(expectedMessage,
                    exception.getMessage(),
                    () -> "Message did not equal '" + expectedMessage + "', actual message:"
                            + exception.getMessage());
        }
        @Test
        public void UpdateCustomersByIdDBError() {
            when(customersRepository.findById(anyLong())).thenThrow(EmptyResultDataAccessException.class);
            assertThrows(ServiceUnavailable.class,
                    () -> customersServiceImpl.UpdateCustomerById(1L, testCustomers));
        }

        @Test
        public void addUser() {
            Customers result = customersServiceImpl.AddCustomers(testCustomers);
            assertEquals(testCustomers, result);
        }
        @Test
        public void addUserEmailConflict(){
            when(customersRepository.existsByEmail(any(String.class))).thenReturn(true);
            assertThrows(Conflict.class,() -> customersServiceImpl.AddCustomers(testCustomers));
        }

        @Test
        public void addUsersDBError() {
            when(customersRepository.save(any(Customers.class))).thenThrow(
                    new EmptyResultDataAccessException("Database unavailable", 0));
            assertThrows(ServiceUnavailable.class,
                    () -> customersServiceImpl.AddCustomers(testCustomers));
        }

}