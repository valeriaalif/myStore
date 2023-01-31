package com.api.domain.repository;

import com.api.domain.Product;
import com.api.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>>getByCategory(int categoryId);
    Optional <List <Product>>getScarseProducts(int quantity);
    Optional<Producto> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);

