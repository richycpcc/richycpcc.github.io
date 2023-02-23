package io.catalyte.springboot.services;

import io.catalyte.springboot.entities.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    List<Orders> GetAllOrders(Orders orders);
    Orders GetOrderById(Long id);
    void DeleteOrderById(Long id);
    Orders UpdateOrderById(Long id, Orders orders);
    Orders AddOrder(Orders orders);
}
