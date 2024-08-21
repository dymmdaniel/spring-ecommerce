package com.dm.ecommerce.user_service.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("country")
public class Country {

    @Id
    private String countryId;

    @NotNull
    private String name;

    @NotNull
    private String shortName;

    @NotNull
    private Integer phoneCode;


}
