package com.demo.spring_liquibase.service;

import com.demo.spring_liquibase.model.OrderModel;
import com.demo.spring_liquibase.model.ProductModel;
import com.demo.spring_liquibase.model.UserModel;
import com.demo.spring_liquibase.repository.OrderRepository;
import com.demo.spring_liquibase.repository.ProductRepository;
import com.demo.spring_liquibase.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    public boolean placeOrder(OrderModel order) {
        log.info("Request received :: {}", order);

        try {
            if (!userRepo.existsById(order.getUser_id()) || !productRepo.existsById(order.getProduct_id())) {
                log.warn("User or Product does not exist");
                return false;
            }

            ProductModel productDetails = productRepo.getReferenceById(order.getProduct_id());
            int availableStocks = productDetails.getAvailable_stocks();

            if (order.getQuantity() > availableStocks) {
                log.warn("Insufficient stocks for productId: {}", order.getProduct_id());
                return false;
            }

            orderRepo.save(order);
            log.info("Order placed successfully for userId: {}", order.getUser_id());
            return true;

        } catch (Exception e) {
            log.error("Error occurred while placing the order", e);
            return false;
        }
    }

}
