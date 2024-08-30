package com.dm.ecommerce.common_service.service.impl;

import com.dm.ecommerce.common_service.service.CommonMongoService;
import com.dm.ecommerce.common_service.service.CommonSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class CommonMongoServiceImpl<E,R extends MongoRepository<E,String>> implements CommonMongoService<E> {

    @Autowired
    protected R repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findALL() {

        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<E> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(String id) {

        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {

        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(String id) {

        repository.deleteById(id);

    }

    @Override
    public boolean existById(String id) {
        return repository.existsById(id);
    }
}
