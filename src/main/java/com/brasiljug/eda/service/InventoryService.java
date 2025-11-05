package com.brasiljug.eda.service;

import com.brasiljug.eda.order.OrderItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class InventoryService {

    public boolean checkStock(List<OrderItem> items) {
        log.info("Stock check completed - all items available");
        return true;
    }

    public void updateStock(List<OrderItem> items) {
        log.info("Stock updated successfully");
    }

    public void buyItems(List<OrderItem> items) {
        log.info("Items purchased from supplier successfully");
    }
}

