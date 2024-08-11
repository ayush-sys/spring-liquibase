package com.demo.spring_liquibase.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "available_stocks", nullable = false)
    private int availableStocks;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderModel> orders;
    
}
