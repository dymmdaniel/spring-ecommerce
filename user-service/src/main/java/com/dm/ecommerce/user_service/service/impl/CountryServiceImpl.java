package com.dm.ecommerce.user_service.service.impl;

import com.dm.ecommerce.common_service.service.impl.CommonMongoServiceImpl;
import com.dm.ecommerce.user_service.model.Country;
import com.dm.ecommerce.user_service.repository.CountryRepository;
import com.dm.ecommerce.user_service.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends CommonMongoServiceImpl<Country, CountryRepository> implements CountryService {
}
