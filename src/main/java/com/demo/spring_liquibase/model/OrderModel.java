package com.demo.spring_liquibase.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private String product_name, email;
    private int user_id, product_id, quantity;
}
