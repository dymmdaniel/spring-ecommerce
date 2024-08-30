package com.dm.ecommerce.user_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("notification")
public class Notification {

    @Id
    private String notificationId;

    private String title;

    private String description;

    private Date time;

    private NotificationType notificationType;

    @DBRef
    private List<User> users;
}
