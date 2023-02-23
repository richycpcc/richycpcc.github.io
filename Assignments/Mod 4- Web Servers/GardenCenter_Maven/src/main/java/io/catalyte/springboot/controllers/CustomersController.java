package io.catalyte.springboot.controllers;

import io.catalyte.springboot.entities.Customers;
import io.catalyte.springboot.repositories.CustomersRepository;
import io.catalyte.springboot.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static io.catalyte.springboot.constants.StringConstants.LOGGER_DELETE_REQUEST_RECEIVED;
import static io.catalyte.springboot.constants.StringConstants.LOGGER_POST_REQUEST_RECEIVED;
import static io.catalyte.springboot.constants.StringConstants.LOGGER_PUT_REQUEST_RECEIVED;
import static io.catalyte.springboot.constants.StringConstants.LOGGER_REQUEST_RECEIVED;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value= "/customers")
public class CustomersController
{
     private final Logger logger = LoggerFactory.getLogger(CustomersController.class);

    @Autowired
    private CustomersService customersService;

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers(Customers customers)
    {
        logger.info(new Date() + LOGGER_REQUEST_RECEIVED);
        return new ResponseEntity<>(customersService.GetAllCustomers(customers),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable("id")Long id)
    {
        logger.info(new Date() + LOGGER_REQUEST_RECEIVED + id);
        return new ResponseEntity<>(customersService.GetCustomerById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable Long id)
    {
        logger.info(new Date() + " Delete request received for id: " + id);
        customersService.DeleteCustomersById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customers> updateCustomerById(@PathVariable Long id, @Valid @RequestBody Customers customers)
    {
      logger.info(new Date() + " Update request received for id: " + id);
      return new ResponseEntity<>(customersService.UpdateCustomerById(id, customers),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customers> save(@Valid @RequestBody Customers customers)
    {
        logger.info(new Date() + " Post request received " + customers.toString());
        return new ResponseEntity<>(customersService.AddCustomers(customers), HttpStatus.CREATED);
    }


}//end class
