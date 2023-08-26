package com.cqrs.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table( name = "Product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "ProductName")
    private String ProductName;

    @Column(name = "ProductPrice")
    private double ProductPrice;

    @Column(name = "ProductDescription")
    private String ProductDescription;


    @Column(name = "ProductQTY")
    private long ProductQTY;

}
