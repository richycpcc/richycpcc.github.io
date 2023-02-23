package io.catalyte.springboot.services;


import io.catalyte.springboot.entities.Products;
import io.catalyte.springboot.exceptions.BadDataResponse;
import io.catalyte.springboot.exceptions.Conflict;
import io.catalyte.springboot.exceptions.ResourceNotFound;
import io.catalyte.springboot.exceptions.ServiceUnavailable;
import io.catalyte.springboot.repositories.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class ProductsServicesImplTest {
    @Mock
    ProductsRepository productRepository;
    @Mock
    ProductsService productsService;
    @InjectMocks
    ProductsServicesImpl productsServiceImpl;

    //variables for expected results
    Products testProducts;
    List<Products> testList = new ArrayList<>();


    @BeforeEach
    @SuppressWarnings("unchecked")
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        testProducts = new Products("10110P","Plant","Knockout Rose","A bush of Knockout Roses", "YMH Gardens", BigDecimal.valueOf(24.99));
        testProducts.setId(1L);
        testList.add(testProducts);


        when(productRepository.findById(any(Long.class))).thenReturn(Optional.of(testList.get(0)));
        when(productRepository.saveAll(anyCollection())).thenReturn(testList);
        when(productRepository.save(any(Products.class))).thenReturn(testList.get(0));
        when(productRepository.findAll()).thenReturn(testList);
        when(productRepository.findAll(any(Example.class))).thenReturn(testList);

    }


    @Test
    public void getAllCustomers() {
        List<Products> result = productsServiceImpl.GetAllProducts(new Products());
        assertEquals(testList, result);
    }
    @Test
    public void GetAllProductsWithSample() {
        List<Products> result = productsServiceImpl.GetAllProducts(testProducts);
        assertEquals(testList, result);
    }
    @Test
    public void GetAllProductsByIdDBError() {
        when(productRepository.findAll(any(Example.class))).thenThrow(EmptyResultDataAccessException.class);
        assertThrows(ServiceUnavailable.class,
                () -> productsServiceImpl.GetAllProducts(testProducts));
    }

    @Test
    public void getProductsById() {
        Products result = productsServiceImpl.GetProductById(1L);
        assertEquals(testProducts, result);
    }

    @Test
    public void GetProductByIdNotFound() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(ResourceNotFound.class,
                () -> productsServiceImpl.GetProductById(1L));
        String expectedMessage = "Could not locate a Product with the id: 1";
        assertEquals(expectedMessage,
                exception.getMessage(),
                () -> "Message did not equal '" + expectedMessage + "', actual message:"
                        + exception.getMessage());
    }
    @Test
    public void GetProductByIdDBError() {
        when(productRepository.findById(anyLong())).thenThrow(EmptyResultDataAccessException.class);
        assertThrows(ServiceUnavailable.class,
                () -> productsServiceImpl.GetProductById(1L));
    }

    @Test
    public void deleteProductById() {
        when (productRepository.existsById(anyLong())).thenReturn(true);
        productsServiceImpl.DeleteProductById(1L);
        verify(productRepository).deleteById(any());
    }

    @Test
    public void deleteUserBadID() {
        doThrow(new ResourceNotFound("Could not locate a User with the id")).when(productRepository)
                .deleteById(anyLong());
        assertThrows(ResourceNotFound.class,
                () -> productsServiceImpl.DeleteProductById(1L));
    }
    @Test
    public void deleteUserDBError() {
        doThrow(new ServiceUnavailable("Database unavailable")).when(productRepository)
                .existsById(anyLong());
        assertThrows(ServiceUnavailable.class,
                () -> productsServiceImpl.DeleteProductById(1L));
    }


    @Test
    public void UpdateProductById() {
        Products result = productsServiceImpl.UpdateProductById(1L, testProducts);
        assertEquals(testProducts, result);
    }
    @Test
    public void updateUsersByIdNotFound() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFound.class,
                () -> productsServiceImpl.UpdateProductById(1L, testProducts));
        String expectedMessage = "Could not locate a Product with the id: 1";
        assertEquals(expectedMessage,
                exception.getMessage(),
                () -> "Message did not equal '" + expectedMessage + "', actual message:"
                        + exception.getMessage());
    }

    @Test
    public void updateUsersByIdBadData() {
        Exception exception = assertThrows(BadDataResponse.class,
                () -> productsServiceImpl.UpdateProductById(2L, testProducts));
        String expectedMessage = "Product ID must match the ID specified in the URL";
        assertEquals(expectedMessage,
                exception.getMessage(),
                () -> "Message did not equal '" + expectedMessage + "', actual message:"
                        + exception.getMessage());
    }
    @Test
    public void UpdateCustomersByIdDBError() {
        when(productRepository.findById(anyLong())).thenThrow(EmptyResultDataAccessException.class);
        assertThrows(ServiceUnavailable.class,
                () -> productsServiceImpl.UpdateProductById(1L, testProducts));
    }

    @Test
    public void addProduct() {
        Products result = productsServiceImpl.AddProduct(testProducts);
        assertEquals(testProducts, result);
    }


    @Test
    public void addProductDBError() {
        when(productRepository.save(any(Products.class))).thenThrow(
                new EmptyResultDataAccessException("Database unavailable", 0));
        assertThrows(ServiceUnavailable.class,
                () -> productsServiceImpl.AddProduct(testProducts));
    }

}