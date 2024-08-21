package com.dm.ecommerce.user_service.service;

import com.dm.ecommerce.common_service.service.CommonSQLService;
import com.dm.ecommerce.user_service.model.Role;

import java.util.List;

public interface RoleService extends CommonSQLService<Role> {
    List<Role> findByName(String name);
}
