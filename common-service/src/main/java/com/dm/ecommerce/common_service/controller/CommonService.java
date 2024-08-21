package com.dm.ecommerce.common_service.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@Component
//@CrossOrigin("{http://localhost:4200}")
public class CommonService {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/liveness")
    public ResponseEntity<?> liveness() {
        Map<String, String> response = new HashMap<>();
        response.put("message", messageSource.getMessage("proyect.liveness", null, new Locale("es")));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    protected ResponseEntity<?> validate(BindingResult result) {
        Map<String, Object> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getObjectName(), err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
