package com.demo.spring_liquibase.service;

import com.demo.spring_liquibase.model.OrderModel;
import com.demo.spring_liquibase.model.ProductModel;
import com.demo.spring_liquibase.repository.OrderRepository;
import com.demo.spring_liquibase.repository.ProductRepository;
import com.demo.spring_liquibase.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            if (!userRepo.existsById(order.getUser().getId()) || !productRepo.existsById(order.getProduct().getProductId())) {
                log.warn("User or Product does not exist");
                return false;
            }

            ProductModel productDetails = productRepo.getReferenceById(order.getProduct().getProductId());
            int availableStocks = productDetails.getAvailableStocks();

            if (order.getQuantity() > availableStocks) {
                log.warn("Insufficient stocks for productId: {}", order.getProduct().getProductId());
                return false;
            }

            orderRepo.save(order);
            log.info("Order placed successfully for userId: {}", order.getUser().getId());
            return true;

        } catch (Exception e) {
            log.error("Error occurred while placing the order", e);
            return false;
        }
    }

}
