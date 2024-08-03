package com.demo.spring_liquibase.repository;

import com.demo.spring_liquibase.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
}
