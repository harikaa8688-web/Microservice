package com.tejait.payment_service;

import lombok.Data;

@Data
public class PaymentRequest {

    private Long orderId;
    private int amount;


}
