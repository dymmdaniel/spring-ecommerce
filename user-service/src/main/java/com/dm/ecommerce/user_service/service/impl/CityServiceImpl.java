package com.dm.ecommerce.user_service.service.impl;

import com.dm.ecommerce.common_service.service.impl.CommonMongoServiceImpl;
import com.dm.ecommerce.user_service.model.City;
import com.dm.ecommerce.user_service.repository.CityRepository;
import com.dm.ecommerce.user_service.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends CommonMongoServiceImpl<City, CityRepository> implements CityService {
}
