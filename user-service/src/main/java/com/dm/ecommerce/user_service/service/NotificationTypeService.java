package com.dm.ecommerce.user_service.service;

import com.dm.ecommerce.common_service.service.CommonSQLService;
import com.dm.ecommerce.user_service.model.NotificationType;

import java.util.List;

public interface NotificationTypeService extends CommonSQLService<NotificationType> {
    NotificationType findByName(String name);
}
