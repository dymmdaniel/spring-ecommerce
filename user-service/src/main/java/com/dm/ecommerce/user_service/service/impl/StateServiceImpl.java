package com.dm.ecommerce.user_service.service.impl;

import com.dm.ecommerce.common_service.service.impl.CommonMongoServiceImpl;
import com.dm.ecommerce.user_service.model.State;
import com.dm.ecommerce.user_service.repository.StateRepository;
import com.dm.ecommerce.user_service.service.StateService;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl extends CommonMongoServiceImpl<State, StateRepository> implements StateService {
}
