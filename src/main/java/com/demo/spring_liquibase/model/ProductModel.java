package com.demo.spring_liquibase.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private int available_stocks;
    private String product_name;
}
