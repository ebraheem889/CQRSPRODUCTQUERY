package com.cqrs.demo.service.apstraction;

import com.cqrs.demo.entity.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(long ProductId) throws Exception;
    List<Product> getProducts();
}
