package com.tejait.order_service;

import lombok.Data;

@Data
public class OrderRequestDto {

    private int productId;
    private int amount;
    private int qty;
}
