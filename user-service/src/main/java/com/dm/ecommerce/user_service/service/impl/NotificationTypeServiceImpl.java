package com.dm.ecommerce.user_service.service.impl;

import com.dm.ecommerce.common_service.service.impl.CommonSQLServiceImpl;
import com.dm.ecommerce.user_service.model.NotificationType;
import com.dm.ecommerce.user_service.model.Role;
import com.dm.ecommerce.user_service.repository.NotificationTypeRepository;
import com.dm.ecommerce.user_service.repository.RoleRepository;
import com.dm.ecommerce.user_service.service.NotificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationTypeServiceImpl extends CommonSQLServiceImpl<NotificationType, NotificationTypeRepository> implements NotificationTypeService {

    @Autowired
    private NotificationTypeRepository notificationTypeRepository;

    @Override
    public NotificationType findByName(String name) {
        return this.notificationTypeRepository.findByName(name);
    }
}
