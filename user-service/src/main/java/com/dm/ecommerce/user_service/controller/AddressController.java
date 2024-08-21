package com.dm.ecommerce.user_service.controller;

import com.dm.ecommerce.common_service.controller.CommonMongoController;
import com.dm.ecommerce.user_service.model.Address;
import com.dm.ecommerce.user_service.model.User;
import com.dm.ecommerce.user_service.service.AddressService;
import com.dm.ecommerce.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/address")
public class AddressController extends CommonMongoController<Address, AddressService> {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Address entity, BindingResult result) {
        if(result.hasErrors()){
            return super.validate(result);
        }
        Optional<User> optionalUser = this.userService.findById(entity.getUserId());
        if (!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<Address> addresses = new ArrayList<>();
        if(optionalUser.get().getAddresses()==null){
            addresses.add(entity);
        }else{
            addresses = optionalUser.get().getAddresses();
            addresses.add(entity);
        }
        optionalUser.get().setAddresses(addresses);
        super.create(entity, result);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.save(optionalUser.get()));
    }
}
