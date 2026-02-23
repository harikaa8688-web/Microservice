package com.tejait.Inventory_service;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("inventory")
public class InventoryController {

    InventoryRepository repository;

    @PostMapping("add")
    public Inventory saveInventoryDetails(@RequestBody Inventory inventory){

        return repository.save(inventory);
    }

    @GetMapping("getQty/{productId}/{requestQty}")
    public Boolean getProductQty(@PathVariable Integer productId, @PathVariable Integer requestQty){
       Inventory productInfo =repository.findByProductId(productId);
       return productInfo.getStockQty()>=requestQty;
    }
    }

