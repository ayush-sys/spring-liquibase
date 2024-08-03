package com.demo.spring_liquibase.controller;

import com.demo.spring_liquibase.model.OrderModel;
import com.demo.spring_liquibase.model.UserModel;
import com.demo.spring_liquibase.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/controller")
public class RequestConroller {

    @Autowired
    private OrderService service;

    @GetMapping("/health-check")
    public ResponseEntity<String> getHealthCheckStatus() {
        return ResponseEntity.ok("application started successfully!");
    }

    @PostMapping("/place-order")
    public ResponseEntity<String> addNewUser(@RequestBody OrderModel order) {
        String message = service.placeOrder(order) ? "Order placed successfully!" : "Order could not be placed.";
        return ResponseEntity.ok(message);
    }

}
