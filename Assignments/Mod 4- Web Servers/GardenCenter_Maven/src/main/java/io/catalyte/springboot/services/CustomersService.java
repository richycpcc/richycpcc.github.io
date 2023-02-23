package io.catalyte.springboot.services;
import io.catalyte.springboot.entities.Customers;

import java.util.List;
import java.util.Optional;


public interface CustomersService {

    List<Customers> GetAllCustomers(Customers customers);
    Customers GetCustomerById(Long id);
    void DeleteCustomersById(Long id);
    Customers UpdateCustomerById(Long id, Customers customers);
    Customers AddCustomers(Customers customers);

}
