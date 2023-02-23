package io.catalyte.springboot.services;

import io.catalyte.springboot.entities.Customers;
import io.catalyte.springboot.exceptions.*;
import io.catalyte.springboot.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import javax.naming.ServiceUnavailableException;
import java.util.List;

import static io.catalyte.springboot.constants.StringConstants.*;


@Service
public class CustomersServiceImpl implements CustomersService{
    @Autowired
    private CustomersRepository customersRepository;

    private Customers customers;
    boolean emailAlreadyExists;


    @Autowired
    public CustomersServiceImpl(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    /**
     * Reads all Customers from the database
     * @param
     * @return List of all Customers in database
     */
    public List<Customers> GetAllCustomers(Customers customers)
    {
        try
        {
            if (customers.equals(null))
            {
                return customersRepository.findAll();
            }
            else
            {
                Example<Customers> customersExample = Example.of(customers);
                return customersRepository.findAll(customersExample);
            }
        }
        catch(Exception e)
        {
            throw new ServiceUnavailable(e);
        }
    }

    /**
     * Search Customer by id in database
     * @param id - Id of Customer to lookup
     * @return - The Customer belonging to the Id or a 404 if not found
     */
    public Customers GetCustomerById(Long id)
    {
        try
        {
            Customers customersLookUpRequest = customersRepository.findById(id).orElse(null);
            if(customersLookUpRequest != null)
            {
                return customersLookUpRequest;
            }
        }
        catch (Exception e)
        {
            throw new ServiceUnavailable(e);
        }
        throw new ResourceNotFound("Could not locate a Customer with the id: " + id);
    }

    /**
     * Deletes a Customer from the database by Id
     * @param id - Id of the Customer to delete
     */
    public void DeleteCustomersById(Long id)
    {
        try
        {
            if(customersRepository.existsById(id))
            {
                customersRepository.deleteById(id);
                return;
            }
        }
        catch(Exception e)
        {
            throw new ServiceUnavailable(e);
        }
        // if we made it down to this point, we did not find the Vaccination
        throw new ResourceNotFound("Could not locate a Customer with the id: " + id);
    }

    /**
     * Updates the database information for an existing Customer. Does not insert a record if the
     * id does not exist.
     * @param id - the id of the Customer to update.
     * @param customers - the supplied Customer information to update the database record.
     * @return - the updated Customer or a 404 if the Vaccination was not found
     */
   public Customers UpdateCustomerById(Long id, Customers customers)
   {
        if(!customers.getId().equals(id))
        {
            throw new BadDataResponse("Customer ID must match the ID specified in the URL");
        }
        try
        {
            Customers customersFromDb = customersRepository.findById(id).orElse(null);
            if(customersFromDb != null)
            {
                //check if email already exists
                //**check email doesn't work. Says can't find Id??
                emailAlreadyExists = customersRepository.existsByEmail(customers.getEmail());
                if(!emailAlreadyExists)
                {
                    return customersRepository.save(customers);
                }
            }
        }
        catch (Exception e)
        {
            throw new ServiceUnavailable(e);
        }
       // if we made it down to this point, we did not find the Customer
       throw new ResourceNotFound("Could not locate a Customer with the id: " + id);

   }
    /**
     * Writes a new customer to the database.
     *
     * @param customers - the Customer to write.
     * @return - the new Customer
     */
    public Customers AddCustomers(Customers customers)
    {
//         if (!ValidStates.validStatesList.contains(customers.getAddress().getState()))
//         {
//         throw new BadDataResponse(BAD_REQUEST_STATE);
//        }
        try
        {
            //check if email already exists
            emailAlreadyExists = customersRepository.existsByEmail(customers.getEmail());
            if (!emailAlreadyExists)
            {
                //assign Users to address before you call Save
                //if this code is used, causes infinite loop when Post Request is used.
                //customers.getAddress().setCustomers(customers);
                return customersRepository.save(customers);
            }
        }
        catch (Exception e)
        {
//            {
//                throw new BadDataResponse((BAD_REQUEST_EMAIL));
            throw new ServiceUnavailable(e);
//            }
            //if made it to this point, email in not unique
        }
        throw new Conflict(EMAIL_CONFLICT);

    }
}//end class
