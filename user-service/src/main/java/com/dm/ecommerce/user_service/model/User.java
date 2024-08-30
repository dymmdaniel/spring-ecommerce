package com.dm.ecommerce.user_service.model;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("user")
public class User {

    @Id
    private String userId;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private List<Role> roles;

    @DBRef
    private List<Comment> comments;

    @DBRef
    private List<Address> addresses;

}
