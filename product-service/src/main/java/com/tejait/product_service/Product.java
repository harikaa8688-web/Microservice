package com.tejait.product_service;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="product_b15")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
}
