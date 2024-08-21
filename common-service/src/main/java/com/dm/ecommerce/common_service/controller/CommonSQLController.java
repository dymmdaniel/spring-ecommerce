package com.dm.ecommerce.common_service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import com.dm.ecommerce.common_service.service.CommonSQLService;

@RestController
public class CommonSQLController<E, S extends CommonSQLService<E>> extends CommonService{

    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok().body(service.findALL());
    }

    @GetMapping("/page")
    public ResponseEntity<?> list(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<E> optional = service.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody E entity, BindingResult result) {
        if (result.hasErrors()) {
            return this.validate(result);
        }

        E entityBD = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
