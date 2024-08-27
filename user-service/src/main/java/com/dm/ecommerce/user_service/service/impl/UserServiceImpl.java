package com.dm.ecommerce.user_service.service.impl;

import com.dm.ecommerce.common_service.service.impl.CommonMongoServiceImpl;
import com.dm.ecommerce.user_service.model.User;
import com.dm.ecommerce.user_service.repository.UserRepository;
import com.dm.ecommerce.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends CommonMongoServiceImpl<User, UserRepository> implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findByRolesRoleId(String roleId) {
        return userRepository.findByRolesRoleId(roleId);
    }
}
