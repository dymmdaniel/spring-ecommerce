package com.dm.ecommerce.user_service.controller;

import com.dm.ecommerce.common_service.controller.CommonMongoController;
import com.dm.ecommerce.user_service.config.Message;
import com.dm.ecommerce.user_service.model.Role;
import com.dm.ecommerce.user_service.model.User;
import com.dm.ecommerce.user_service.service.RoleService;
import com.dm.ecommerce.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/user")
public class UserController extends CommonMongoController<User, UserService> {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid User entity, BindingResult result) {
        List<Role> roles = this.roleService.findByName("ROLE_USER");
        entity.setRoles(roles);
        return super.create(entity, result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid Map<String, String> login, BindingResult result){
        if (result.hasErrors()) {
            return super.validate(result);
        }

        if (!login.containsKey("user") | !login.containsKey("password")) {
            Map<String, String> body = new HashMap<>();
            body.put("message", Message.get("user.login"));
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
        }

        return null;
    }
}
