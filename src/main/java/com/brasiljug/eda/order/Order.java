package com.brasiljug.eda.order;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {
    private String id;
    private List<OrderItem> items;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private String sellerId;
    private String shippingAddress;
    private String customerEmail;
    private String status;
}

