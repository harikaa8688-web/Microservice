package com.tejait.notification_service;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@RestController
@RequestMapping("notification")
public class NotificationController {

    NotificationRepository repository;

    @PostMapping("send")
    public Notification sendnotification(@RequestBody String message){

                   Notification notification= new Notification();
                   notification.setMessage(message);
                   notification.setSentAt(LocalDateTime.now());
                   return repository.save(notification);

    }
}
