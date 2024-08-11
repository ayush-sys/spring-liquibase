package com.demo.spring_liquibase.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private ProductModel product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserModel user;

}

