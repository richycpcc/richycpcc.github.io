package io.catalyte.springboot.services;


import io.catalyte.springboot.entities.Orders;
import io.catalyte.springboot.exceptions.BadDataResponse;
import io.catalyte.springboot.exceptions.ResourceNotFound;
import io.catalyte.springboot.exceptions.ServiceUnavailable;
import io.catalyte.springboot.repositories.OrdersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class OrdersServiceImplTest {
    @Mock
    OrdersRepository ordersRepository;
    @Mock
   OrdersService ordersService;
    @InjectMocks
    OrdersServiceImpl ordersServiceImpl;

    //variables for expected results
    Orders testOrders;
    List<Orders> testList = new ArrayList<>();


    @BeforeEach
    @SuppressWarnings("unchecked")
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        testOrders = new Orders(

                Date.from(LocalDate.parse("2023-02-20").atStartOfDay(ZoneId.systemDefault()).toInstant()),
                BigDecimal.valueOf(100.00));
        testOrders.setId(1L);
        testList.add(testOrders);


        when(ordersRepository.findById(any(Long.class))).thenReturn(Optional.of(testList.get(0)));
        when(ordersRepository.saveAll(anyCollection())).thenReturn(testList);
        when(ordersRepository.save(any(Orders.class))).thenReturn(testList.get(0));
        when(ordersRepository.findAll()).thenReturn(testList);
        when(ordersRepository.findAll(any(Example.class))).thenReturn(testList);

    }


    @Test
    public void getAllCustomers() {
        List<Orders> result = ordersServiceImpl.GetAllOrders(new Orders(Date.from(LocalDate.parse("2023-02-20").atStartOfDay(ZoneId.systemDefault()).toInstant()), BigDecimal.valueOf(100.00)));
        assertEquals(testList, result);
    }
    @Test
    public void GetAllOrdersWithSample() {
        List<Orders> result = ordersServiceImpl.GetAllOrders(testOrders);
        assertEquals(testList, result);
    }
    @Test
    public void GetAllOrdersByIdDBError() {
        when(ordersRepository.findAll(any(Example.class))).thenThrow(EmptyResultDataAccessException.class);
        assertThrows(ServiceUnavailable.class,
                () -> ordersServiceImpl.GetAllOrders(testOrders));
    }

    @Test
    public void getOrderById() {
        Orders result = ordersServiceImpl.GetOrderById(1L);
        assertEquals(testOrders, result);
    }

    @Test
    public void GetOrderByIdNotFound() {
        when(ordersRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(ResourceNotFound.class,
                () -> ordersServiceImpl.GetOrderById(1L));
        String expectedMessage = "Could not locate an Order with the id: 1";
        assertEquals(expectedMessage,
                exception.getMessage(),
                () -> "Message did not equal '" + expectedMessage + "', actual message:"
                        + exception.getMessage());
    }
    @Test
    public void GetOrderByIdDBError() {
        when(ordersRepository.findById(anyLong())).thenThrow(EmptyResultDataAccessException.class);
        assertThrows(ServiceUnavailable.class,
                () -> ordersServiceImpl.GetOrderById(1L));
    }

    @Test
    public void deleteOrderById() {
        when (ordersRepository.existsById(anyLong())).thenReturn(true);
        ordersServiceImpl.DeleteOrderById(1L);
        verify(ordersRepository).deleteById(any());
    }

    @Test
    public void deleteOrderBadID() {
        doThrow(new ResourceNotFound("Could not locate an Order with the id")).when(ordersRepository)
                .deleteById(anyLong());
        assertThrows(ResourceNotFound.class,
                () -> ordersServiceImpl.DeleteOrderById(1L));
    }
    @Test
    public void deleteOrderDBError() {
        doThrow(new ServiceUnavailable("Database unavailable")).when(ordersRepository)
                .existsById(anyLong());
        assertThrows(ServiceUnavailable.class,
                () -> ordersServiceImpl.DeleteOrderById(1L));
    }


    @Test
    public void UpdateOrdersById() {
        Orders result = ordersServiceImpl.UpdateOrderById(1L, testOrders);
        assertEquals(testOrders, result);
    }
    @Test
    public void updateUsersByIdNotFound() {
        when(ordersRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFound.class,
                () -> ordersServiceImpl.UpdateOrderById(1L, testOrders));
        String expectedMessage = "Could not locate an Orders with the id: 1";
        assertEquals(expectedMessage,
                exception.getMessage(),
                () -> "Message did not equal '" + expectedMessage + "', actual message:"
                        + exception.getMessage());
    }

    @Test
    public void updateUsersByIdBadData() {
        Exception exception = assertThrows(BadDataResponse.class,
                () -> ordersServiceImpl.UpdateOrderById(2L, testOrders));
        String expectedMessage = "Order ID must match the ID specified in the URL";
        assertEquals(expectedMessage,
                exception.getMessage(),
                () -> "Message did not equal '" + expectedMessage + "', actual message:"
                        + exception.getMessage());
    }
    @Test
    public void UpdateCustomersByIdDBError() {
        when(ordersRepository.findById(anyLong())).thenThrow(EmptyResultDataAccessException.class);
        assertThrows(ServiceUnavailable.class,
                () -> ordersServiceImpl.UpdateOrderById(1L, testOrders));
    }

    @Test
    public void addOrders() {
        Orders result = ordersServiceImpl.AddOrder(testOrders);
        assertEquals(testOrders, result);
    }


    @Test
    public void addOrdersDBError() {
        when(ordersRepository.save(any(Orders.class))).thenThrow(
                new EmptyResultDataAccessException("Database unavailable", 0));
        assertThrows(ServiceUnavailable.class,
                () -> ordersServiceImpl.AddOrder(testOrders));
    }

}