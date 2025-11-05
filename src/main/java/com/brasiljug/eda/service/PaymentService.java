package com.brasiljug.eda.service;

import com.brasiljug.eda.order.Order;
import com.brasiljug.eda.service.response.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentService {

    public PaymentResponse processPayment(Order order) {
        log.info("Payment processed successfully for order: {}", order.getId());
        return new PaymentResponse(Boolean.TRUE);
    }
}

