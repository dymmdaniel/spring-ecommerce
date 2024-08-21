package com.dm.ecommerce.user_service.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("address")
public class Address {

    @Id
    private String addressId;

    @NotNull
    private String userId;

    @NotNull
    private String title;

    @NotNull
    private String address;

    private String additional;

    @NotNull
    private String name;

    @NotNull
    private String number;

    @NotNull
    private Integer postalCode;

    @DBRef
    private Country country;

    @DBRef
    private State state;

    @DBRef
    private City city;
}
