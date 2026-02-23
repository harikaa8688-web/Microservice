package com.tejait.api_gateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback/product")
    public ResponseEntity<String> productFallback(){
        return new ResponseEntity<>("Product service has Issue please contact Harry Potter:8688632568", HttpStatus.SERVICE_UNAVAILABLE);
    }
    @GetMapping("/fallback/inventory")
    public ResponseEntity<String> inventoryFallback(){
        return new ResponseEntity<>("Inventory service has Issue please contact Harry Potter:8688632568", HttpStatus.SERVICE_UNAVAILABLE);
    }
    @GetMapping("/fallback/payment")
    public ResponseEntity<String> paymentFallback(){
        return new ResponseEntity<>("Payment service has Issue please contact Harry Potter:8688632568", HttpStatus.SERVICE_UNAVAILABLE);
    }
    @GetMapping("//fallback/notification")
    public ResponseEntity<String> notificationFallback(){
        return new ResponseEntity<>("Notofication service has Issue please contact Harry Potter:8688632568", HttpStatus.SERVICE_UNAVAILABLE);
    }
    @GetMapping("/fallback/order")
    public ResponseEntity<String> orderFallback(){
        return new ResponseEntity<>("Order service has Issue please contact Harry Potter:8688632568", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
