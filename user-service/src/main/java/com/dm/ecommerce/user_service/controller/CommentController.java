package com.dm.ecommerce.user_service.controller;

import com.dm.ecommerce.common_service.controller.CommonMongoController;
import com.dm.ecommerce.user_service.model.Address;
import com.dm.ecommerce.user_service.model.Comment;
import com.dm.ecommerce.user_service.model.User;
import com.dm.ecommerce.user_service.service.CommentService;
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
@RequestMapping("/comment")
public class CommentController extends CommonMongoController<Comment, CommentService> {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Comment entity, BindingResult result) {
        if(result.hasErrors()){
            return super.validate(result);
        }
        Optional<User> optionalUser = this.userService.findById(entity.getUserId());
        if (!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<Comment> Comment = new ArrayList<>();
        if(optionalUser.get().getComments()==null || optionalUser.get().getComments().isEmpty()){
            Comment.add(entity);
        }else{
            Comment = optionalUser.get().getComments();
            Comment.add(entity);
        }
        optionalUser.get().setComments(Comment);
        super.create(entity, result);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.save(optionalUser.get()));
    }
}
