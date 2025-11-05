package com.brasiljug.eda.order;

import lombok.Data;

@Data
public class OrderItem {
    private String productId;
    private int quantity;
}

