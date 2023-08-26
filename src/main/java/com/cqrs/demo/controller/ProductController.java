package com.cqrs.demo.controller;


import com.cqrs.demo.entity.Product;
import com.cqrs.demo.service.apstraction.ProductService;
import com.cqrs.demo.service.implementation.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {


    private ProductService productService;


    @Autowired
    public ProductController( ProductServiceImpl productService){
        this.productService =  productService;
    }


    @GetMapping
    Product getProductById(@PathVariable Long ProductId) throws Exception{
        return productService.getProductById(ProductId);
    }

    @GetMapping("/All")
    List<Product> getAllProducts(){
        return productService.getProducts();
    }


}
