package com.demo.spring_liquibase.repository;

import com.demo.spring_liquibase.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    // JPQL query to find users whose age is more than a certain age
    @Query("SELECT u FROM UserModel u WHERE u.age > :age")
    List<UserModel> findUsersByAge(@Param("age") int age);

    // Native SQL query to find users whose email contains a certain domain
    @Query(value = "SELECT * FROM users WHERE email LIKE %:domain%", nativeQuery = true)
    List<UserModel> findUsersByDomain(@Param("domain") String domain);

}
