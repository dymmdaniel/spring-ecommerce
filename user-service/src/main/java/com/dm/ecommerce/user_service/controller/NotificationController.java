package com.dm.ecommerce.user_service.controller;

import com.dm.ecommerce.common_service.controller.CommonMongoController;
import com.dm.ecommerce.user_service.config.Message;
import com.dm.ecommerce.user_service.model.Notification;
import com.dm.ecommerce.user_service.model.NotificationType;
import com.dm.ecommerce.user_service.model.Role;
import com.dm.ecommerce.user_service.model.User;
import com.dm.ecommerce.user_service.service.NotificationService;
import com.dm.ecommerce.user_service.service.NotificationTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/notification")
public class NotificationController extends CommonMongoController<Notification, NotificationService> {

    @Autowired
    private NotificationTypeService notificationTypeService;
    

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Notification entity, BindingResult result) {
        if (result.hasErrors()) {
            return super.validate(result);
        }

        if (entity.getNotificationType()==null) {
            Map<String, String> body = new HashMap<>();
            body.put("message", Message.get("notification.type"));
            System.out.println(body);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }
        NotificationType notificationType = this.notificationTypeService.findByName(entity.getNotificationType().getName());
        entity.setNotificationType(notificationType);
        return super.create(entity,result);
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addUser(@PathVariable("userId")String userId,@RequestParam("notificationId")String notificationId){

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}