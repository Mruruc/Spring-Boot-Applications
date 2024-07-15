package com.mruruc.repository;

import com.mruruc.custom_aop.annotations.After;
import com.mruruc.custom_aop.annotations.Before;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, ID> {
    @Before
    @After
    T save(T entity);

    @Before
    @After
    Optional<T> findById(ID id);

    @Before
    @After
    List<T> findAll();

    @Before
    @After
    void delete(ID id);
}
