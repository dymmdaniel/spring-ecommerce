package com.dm.ecommerce.user_service.repository;

import com.dm.ecommerce.user_service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    List<Role> findByName(String name);
}
