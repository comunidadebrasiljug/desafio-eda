package com.brasiljug.eda.service;

import com.brasiljug.eda.order.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

    public void sendOrderConfirmation(Order order) {
        log.info("Order ID: {}", order.getId());
        log.info("Order confirmation email sent successfully");
    }
}

