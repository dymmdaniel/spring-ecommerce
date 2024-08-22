package com.dm.ecommerce.user_service.repository;

import com.dm.ecommerce.user_service.model.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationTypeRepository extends JpaRepository<NotificationType,String> {
    NotificationType findByName(String name);
}
