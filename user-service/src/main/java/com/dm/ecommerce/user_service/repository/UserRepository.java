package com.dm.ecommerce.user_service.repository;

import com.dm.ecommerce.user_service.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    List<User> findByRolesRoleId(String roleId);
}
