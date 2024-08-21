package com.dm.ecommerce.user_service.repository;

import com.dm.ecommerce.user_service.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<City,String> {
}
