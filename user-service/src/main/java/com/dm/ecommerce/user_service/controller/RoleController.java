package com.dm.ecommerce.user_service.controller;

import com.dm.ecommerce.common_service.controller.CommonMongoController;
import com.dm.ecommerce.common_service.controller.CommonSQLController;
import com.dm.ecommerce.user_service.model.Role;
import com.dm.ecommerce.user_service.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/role")
public class RoleController extends CommonSQLController<Role, RoleService> {

}
