package com.tejait.order_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository repository;

    WebClient webClient;

    public Orders saveOrder(OrderRequestDto request) {
        Orders orders= new Orders();
              orders.setProductId(request.getProductId()); // productId=1
              orders.setAmount(request.getAmount());
              orders.setQty(request.getQty());

 Product product = webClient.get()
        .uri("http://localhost:8080/products/getById/"+request.getProductId()) // product
        .retrieve()
         .bodyToMono(Product.class)
         .block();

          orders.setProductName(product.getName());
          orders.setOrderStatus("CREATED");
          repository.save(orders); // id=1, productId,name,amount,status;

        //http://localhost:8083/inventory/getQty/{productId}/{requestQty}

  Boolean quantity=webClient.get()
          .uri("http://localhost:8080/inventory/getQty/"+request.getProductId()+"/"+request.getQty()) //inventory
          .retrieve()
          .bodyToMono(Boolean.class)
          .block();

    if(!quantity){
        orders.setOrderStatus("FAILED");
      return  repository.save(orders);
    }

    webClient.post()
            .uri("http://localhost:8080/payment/makePayment")
            .bodyValue(new PaymentRequest(orders.getId(), orders.getAmount()))
            .retrieve()
            .toBodilessEntity();
    webClient.post()
            .uri("http://localhost:8080/notification/send")
            .bodyValue(orders.getId()+" "+orders.getProductName()+" "+"Order placed")
            .retrieve()
            .toBodilessEntity();
    orders.setOrderStatus("CONFIRMED");

        return repository.save(orders);
    }
}
