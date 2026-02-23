package com.tejait.order_service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentRequest {


    private Long orderId;
    private int amount;

}
