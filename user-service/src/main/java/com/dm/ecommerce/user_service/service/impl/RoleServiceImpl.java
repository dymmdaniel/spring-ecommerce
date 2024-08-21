package com.dm.ecommerce.user_service.service.impl;

import com.dm.ecommerce.common_service.service.impl.CommonMongoServiceImpl;
import com.dm.ecommerce.common_service.service.impl.CommonSQLServiceImpl;
import com.dm.ecommerce.user_service.model.Role;
import com.dm.ecommerce.user_service.repository.RoleRepository;
import com.dm.ecommerce.user_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends CommonSQLServiceImpl<Role, RoleRepository> implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
