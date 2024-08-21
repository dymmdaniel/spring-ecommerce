package com.dm.ecommerce.user_service.service.impl;

import com.dm.ecommerce.common_service.service.impl.CommonMongoServiceImpl;
import com.dm.ecommerce.user_service.model.Address;
import com.dm.ecommerce.user_service.repository.AddressRepository;
import com.dm.ecommerce.user_service.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends CommonMongoServiceImpl<Address, AddressRepository> implements AddressService {
}
