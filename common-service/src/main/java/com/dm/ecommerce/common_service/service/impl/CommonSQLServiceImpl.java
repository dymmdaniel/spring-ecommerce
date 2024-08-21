package com.dm.ecommerce.common_service.service.impl;


import java.util.Optional;

import com.dm.ecommerce.common_service.service.CommonSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonSQLServiceImpl<E,R extends JpaRepository<E,String>> implements CommonSQLService<E> {

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
}
