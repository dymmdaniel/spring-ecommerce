package com.dm.ecommerce.common_service.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommonSQLService<E>{
    public Iterable<E> findALL();

    public Page<E> findAll(Pageable pageable);

    public Optional<E> findById(String id);

    public E save(E entity);

    public void deleteById(String id);

    public boolean existsById(String id);
}
