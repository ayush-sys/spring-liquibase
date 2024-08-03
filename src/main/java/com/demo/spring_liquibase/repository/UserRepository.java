package com.demo.spring_liquibase.repository;

import com.demo.spring_liquibase.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
