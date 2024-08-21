package com.dm.ecommerce.common_service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CommonMongoService<E>{
    public Iterable<E> findALL();

    public Page<E> findAll(Pageable pageable);

    public Optional<E> findById(String id);

    public E save(E entity);

    public void deleteById(String id);
}
