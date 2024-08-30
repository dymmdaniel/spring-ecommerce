package com.dm.ecommerce.user_service.controller;

import com.dm.ecommerce.common_service.controller.CommonMongoController;
import com.dm.ecommerce.user_service.config.Message;
import com.dm.ecommerce.user_service.model.*;
import com.dm.ecommerce.user_service.service.NotificationService;
import com.dm.ecommerce.user_service.service.NotificationTypeService;
import com.dm.ecommerce.user_service.service.RoleService;
import com.dm.ecommerce.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;


@RestController
@RequestMapping("/notification")
public class NotificationController extends CommonMongoController<Notification, NotificationService> {

    @Autowired
    private NotificationTypeService notificationTypeService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Notification entity, BindingResult result) {
        if (result.hasErrors()) {
            return super.validate(result);
        }

        if (entity.getNotificationType()==null) {
            Map<String, String> body = new HashMap<>();
            body.put("message", Message.get("notification.type"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

        NotificationType notificationType = this.notificationTypeService.findByName(entity.getNotificationType().getName());
        entity.setNotificationType(notificationType);
        return super.create(entity,result);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<?> addUser(@PathVariable("userId")String userId,@RequestBody @Valid Notification notification, BindingResult result){

        if (result.hasErrors()) {
            return super.validate(result);
        }

        if(!userService.existById(userId)){
            Map<String, String> body = new HashMap<>();
            body.put("message", Message.get("user.exist.id"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

        if(!super.service.existById(notification.getNotificationId())) {
            Map<String, String> body = new HashMap<>();
            body.put("message", Message.get("notification.exist.id"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }
        Optional<Notification> entity = notificationService.findById(notification.getNotificationId());
        entity.get().setTime(Calendar.getInstance().getTime());

        List<User> users = new ArrayList<>();
        User user = userService.findById(userId).get();
        if(entity.get().getUsers()==null || entity.get().getUsers().isEmpty()){
            users.add(user);
        }else{
            users = entity.get().getUsers();
            users.add(user);
        }
        entity.get().setUsers(users);
        return super.create(entity.get(),result);
    }

    @PostMapping("/role/{name}")
    public ResponseEntity<?> addRole(@PathVariable("name")String roleName,@RequestBody @Valid Notification notification, BindingResult result){
        if (result.hasErrors()) {
            return super.validate(result);
        }
        notification.setTime(Calendar.getInstance().getTime());

        List<Role> role = roleService.findByName(roleName);

        if(role.isEmpty()){
            Map<String, String> body = new HashMap<>();
            body.put("message", Message.get("role.exist.name"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

        if(!super.service.existById(notification.getNotificationId())){
            Map<String, String> body = new HashMap<>();
            body.put("message", Message.get("notification.exist.id"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

        List<User> users= userService.findByRolesRoleId(role.get(0).getRoleId());
        if(notification.getUsers()==null || notification.getUsers().isEmpty()){
            users.addAll(users);
        }else{
            users = notification.getUsers();
            users.addAll(users);
        }
        notification.setUsers(users);
        return super.create(notification,result);
    }



}