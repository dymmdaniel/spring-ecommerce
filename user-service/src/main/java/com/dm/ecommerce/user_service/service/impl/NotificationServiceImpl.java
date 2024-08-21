package com.dm.ecommerce.user_service.service.impl;

import com.dm.ecommerce.common_service.service.impl.CommonMongoServiceImpl;
import com.dm.ecommerce.user_service.model.Notification;
import com.dm.ecommerce.user_service.repository.NotificationRepository;
import com.dm.ecommerce.user_service.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl extends CommonMongoServiceImpl<Notification, NotificationRepository> implements NotificationService {
}
