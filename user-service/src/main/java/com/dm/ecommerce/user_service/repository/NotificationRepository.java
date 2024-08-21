package com.dm.ecommerce.user_service.repository;

import com.dm.ecommerce.user_service.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,String> {
}
