package io.catalyte.springboot.controllers;

import io.catalyte.springboot.entities.Orders;

import io.catalyte.springboot.repositories.OrdersRepository;
import io.catalyte.springboot.services.OrdersService;
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
@RequestMapping("/orders")
public class OrdersController {

        private final Logger logger = LoggerFactory.getLogger(OrdersController.class);

        @Autowired
        private OrdersService ordersService;
        @Autowired
        private OrdersRepository ordersRepository;

        @GetMapping
        public ResponseEntity<List<Orders>> getAllOrders(Orders orders)
        {
                logger.info(new Date() + LOGGER_REQUEST_RECEIVED);
                return new ResponseEntity<>(ordersService.GetAllOrders(orders),HttpStatus.OK);
        }

        @GetMapping(path = "/{id}")
        public ResponseEntity<Orders> getOrdersById(@PathVariable("id")Long id)
        {
                logger.info(new Date() + LOGGER_REQUEST_RECEIVED + id);
                return new ResponseEntity<>(ordersService.GetOrderById(id),HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity deleteProductById(@PathVariable Long id)
        {
                logger.info(new Date() + " Delete request received for id: " + id);
                ordersService.DeleteOrderById(id);
                return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<Orders> updateOrderById(@PathVariable Long id, @Valid @RequestBody Orders orders)
        {
                logger.info(new Date() + " Update request received for id: " + id);
                return new ResponseEntity<>(ordersService.UpdateOrderById(id, orders),HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Orders> save(@Valid @RequestBody Orders orders)
        {
                logger.info(new Date() + " Post request received " + orders.toString());
                return new ResponseEntity<>(ordersService.AddOrder(orders), HttpStatus.CREATED);
        }
}
