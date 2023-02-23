package io.catalyte.springboot.controllers;


import io.catalyte.springboot.entities.Products;
import io.catalyte.springboot.repositories.ProductsRepository;
import io.catalyte.springboot.services.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/products")
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts(Products products)
    {
        logger.info(new Date() + LOGGER_REQUEST_RECEIVED);
        return new ResponseEntity<>(productsService.GetAllProducts(products),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable("id")Long id)
    {
        logger.info(new Date() + LOGGER_REQUEST_RECEIVED + id);
        return new ResponseEntity<>(productsService.GetProductById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductById(@PathVariable Long id)
    {
        logger.info(new Date() + " Delete request received for id: " + id);
        productsService.DeleteProductById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Products> updateUserById(@PathVariable Long id, @Valid @RequestBody Products products)
    {
      logger.info(new Date() + " Update request received for id: " + id);
        return new ResponseEntity<>(productsService.UpdateProductById(id, products),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Products> save(@Valid @RequestBody Products products)
    {
          logger.info(new Date() + " Post request received " + products.toString());
        return new ResponseEntity<>(productsService.AddProduct(products), HttpStatus.CREATED);
    }




}//ends class
