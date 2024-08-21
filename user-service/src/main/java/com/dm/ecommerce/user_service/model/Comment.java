package com.dm.ecommerce.user_service.model;

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
@Document("comment")
public class Comment {

    @Id
    private String commentId;

    @DBRef
    private String userId;

    //Asociar al otro microservicio
    private String itemId;

    private String title;

    private String comment;


}
