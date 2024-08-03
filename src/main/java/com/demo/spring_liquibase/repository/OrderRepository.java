package com.demo.spring_liquibase.repository;

import com.demo.spring_liquibase.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Integer> {
}
