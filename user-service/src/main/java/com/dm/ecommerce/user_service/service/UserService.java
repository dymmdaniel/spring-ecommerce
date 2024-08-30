package com.dm.ecommerce.user_service.service;

import com.dm.ecommerce.common_service.service.CommonMongoService;
import com.dm.ecommerce.user_service.model.User;

import java.util.List;

public interface UserService extends CommonMongoService<User> {
    List<User> findByRolesRoleId(String roleId);
}
