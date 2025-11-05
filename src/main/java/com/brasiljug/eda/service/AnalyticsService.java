package com.brasiljug.eda.service;

import com.brasiljug.eda.order.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnalyticsService {

    public void updateSalesAnalytics(Order order) {
        log.info("Updating sales analytics");
    }
}

