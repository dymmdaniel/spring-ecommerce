package com.dm.ecommerce.user_service.service.impl;

import com.dm.ecommerce.common_service.service.impl.CommonMongoServiceImpl;
import com.dm.ecommerce.user_service.model.User;
import com.dm.ecommerce.user_service.repository.UserRepository;
import com.dm.ecommerce.user_service.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CommonMongoServiceImpl<User, UserRepository> implements UserService {
}
