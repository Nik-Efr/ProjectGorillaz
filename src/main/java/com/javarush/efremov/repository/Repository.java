package com.javarush.efremov.repository;

import com.javarush.efremov.entity.User;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T> {

    Collection<User> getAll();

    Optional<T> get(long id);

    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
