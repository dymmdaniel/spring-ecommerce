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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/notification")
public class NotificationController extends CommonMongoController<Notification, NotificationService> {

    @Autowired
    private NotificationTypeService notificationTypeService;

    @PostMapping("/2")
    public ResponseEntity<?> create2(@RequestParam("typeNotification") String nameType, @RequestBody @Valid Notification entity, BindingResult result){
        if(nameType.equalsIgnoreCase("pepe")){
            Map<String, String> body = new HashMap<>();
            body.put("message",Message.get("notification.type"));
            System.out.println(body);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }
        NotificationType notificationType = this.notificationTypeService.findByName(nameType);
        entity.setNotificationType(notificationType);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}