package io.catalyte.springboot.services;



import io.catalyte.springboot.exceptions.BadDataResponse;
import io.catalyte.springboot.exceptions.BadRequest;
import io.catalyte.springboot.exceptions.ResourceNotFound;
import io.catalyte.springboot.exceptions.ServiceUnavailable;
import io.catalyte.springboot.repositories.OrdersRepository;
import io.catalyte.springboot.entities.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static io.catalyte.springboot.constants.StringConstants.BAD_REQUEST_PRICE;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;


    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    /**
     * Reads all Orders from the database
     * @param
     * @return List of all Orders in database
     */

    public List<Orders> GetAllOrders(Orders orders)
    {
        try
        {
            if (orders.equals(null))
            {
                return ordersRepository.findAll();
            }
            else
            {
                Example<Orders> ordersExample = Example.of(orders);
                return ordersRepository.findAll(ordersExample);
            }
        }
        catch(Exception e)
        {
            throw new ServiceUnavailable(e);
        }
    }

    /**
     * Search Customer by id in database
     * @param id -  Id of Order to lookup
     * @return - The Order belonging to the Id or a 404 if not found
     */
    public Orders GetOrderById(Long id)
    {
        try
        {
            Orders ordersLookUpRequest = ordersRepository.findById(id).orElse(null);
            if(ordersLookUpRequest != null)
            {
                return ordersLookUpRequest;
            }
        }
        catch (Exception e)
        {
            throw new ServiceUnavailable(e);
        }
        throw new ResourceNotFound("Could not locate an Order with the id: " + id);
    }

    /**
     * Deletes an Order from the database by Id
     * @param id - Id of the Order to delete
     */
    public void DeleteOrderById(Long id)
    {
        try
        {
            if(ordersRepository.existsById(id))
            {
                ordersRepository.deleteById(id);
                return;
            }
        }
        catch(Exception e)
        {
            throw new ServiceUnavailable(e);
        }
        // if we made it down to this point, we did not find the Orders
        throw new ResourceNotFound("Could not locate a Orders with the id: " + id);
    }

    /**
     Updates the database information for an existing Order. Does not insert a record if the
     * id does not exist.
     * @param id - the id of the Order to update.
     * @param orders - the supplied Order information to update the database record
     * @return - the updated Order or a 404 if the Vaccination was not found
     */
    public Orders UpdateOrderById(Long id,Orders orders)
    {
        if(!orders.getId().equals(id))
        {
            throw new BadDataResponse("Order ID must match the ID specified in the URL");
        }
        if(orders.getOrderTotal().scale() != 2){
            throw new BadRequest(BAD_REQUEST_PRICE);//BAD_REQUEST_PRICE);
        }
        try
        {
            Orders ordersFromDb = ordersRepository.findById(id).orElse(null);
            if(ordersFromDb != null)
            {
                return ordersRepository.save(orders);
            }
        }
        catch (Exception e)
        {
            throw new ServiceUnavailable(e);
        }
        // if we made it down to this point, we did not find the Orders
        throw new ResourceNotFound("Could not locate an Orders with the id: " + id);
    }
    /**
     * Writes a new order to the database.
     *
     * @param orders - the Order to write.
     * @return - the new Order
     */
    public Orders AddOrder(Orders orders)
    {
        if(orders.getOrderTotal().scale() != 2){
            throw new BadRequest(BAD_REQUEST_PRICE);//BAD_REQUEST_PRICE);
        }
        try
        {
            return ordersRepository.save(orders);
        }
        catch (Exception e)
        {
            throw new ServiceUnavailable(e);
        }
    }

}//end class
