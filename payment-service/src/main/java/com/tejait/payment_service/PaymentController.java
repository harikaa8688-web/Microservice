package com.tejait.payment_service;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("payment")
public class PaymentController {

    PaymentRepository repository;

    @PostMapping("makePayment")
    public Payment makePayment(@RequestBody PaymentRequest request){
        Payment payment= new Payment();
               payment.setOrderId(request.getOrderId());
               payment.setAmount(request.getAmount());
               payment.setPaymentStatus("SUCCESS");
        return repository.save(payment);
    }
}
