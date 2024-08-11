package com.demo.spring_liquibase.controller;

import com.demo.spring_liquibase.model.OrderModel;
import com.demo.spring_liquibase.model.UserModel;
import com.demo.spring_liquibase.service.OrderService;
import com.demo.spring_liquibase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/controller")
public class RequestConroller {

    @Autowired
    private OrderService service;

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public ResponseEntity<String> getHealthCheckStatus() {
        return ResponseEntity.ok("application started successfully!");
    }

    @PostMapping("/place-order")
    public ResponseEntity<String> addNewUser(@RequestBody OrderModel order) {
        String message = service.placeOrder(order) ? "Order placed successfully!" : "Order could not be placed.";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/get-users-by-age/{age}")
    public List<UserModel> getUsersByAge(@PathVariable int age){
        return userService.getUsersByAge(age);
    }

    @GetMapping("/get-users-by-domain/{domain}")
    public List<UserModel> getUsersByDomain(@PathVariable String domain){
        return userService.getUsersByDomain(domain);
    }

}
