package com.tejait.product_service;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

    ProductRepository repository;

    @PostMapping("add")
    public Product addProduct(@RequestBody Product product){
     return repository.save(product);
    }

    @GetMapping("getById/{id}")
    public Product getByProductId(@PathVariable Integer id){
       return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
