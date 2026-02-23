package com.tejait.order_service;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("order")
public class OrderController {

    OrderService service;

    @PostMapping("saveOrder")
    public Orders saveOrderdetails(@RequestBody OrderRequestDto request){
       return service.saveOrder(request);

    }
}
