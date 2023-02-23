package io.catalyte.springboot.services;

import io.catalyte.springboot.entities.Products;

import java.util.List;

public interface ProductsService {
    List<Products> GetAllProducts(Products products);
    Products GetProductById(Long id);
    void DeleteProductById(Long id);
    Products UpdateProductById(Long id, Products products);
    Products AddProduct(Products products);
}
