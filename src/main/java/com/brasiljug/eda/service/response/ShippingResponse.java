package com.brasiljug.eda.service.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ShippingResponse {
    private String trackingCode;
    private String status;
}

