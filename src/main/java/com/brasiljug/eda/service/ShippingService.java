package com.brasiljug.eda.service;

import com.brasiljug.eda.order.Order;
import com.brasiljug.eda.service.response.ShippingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Slf4j
@Service
public class ShippingService {

    public ShippingResponse createShipping(Order order) {
        log.info("Creating shipping for order: {}", order.getId());
        String trackingCode = UUID.randomUUID().toString();
        log.info("Shipping created with tracking code: {}", trackingCode);
        return new ShippingResponse(trackingCode, "created");
    }
}

