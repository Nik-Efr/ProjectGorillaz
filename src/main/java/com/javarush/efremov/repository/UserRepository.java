package com.javarush.efremov.repository;

import com.javarush.efremov.entity.Role;
import com.javarush.efremov.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository implements Repository<User> {

    private final Map<Long, User> map = new HashMap<>();

    public static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    public UserRepository() {
        map.put(1L, new User(1L, "Avatar", "qwerty", Role.USER));
        map.put(2L, new User(2L, "Cat", "12345", Role.GUEST));
        map.put(3L, new User(3L, "Robz", "password", Role.USER));
        map.put(4L, new User(4L, "Admin", "admin", Role.ADMIN));
    }

    @Override
    public Collection<User> getAll() {
        return map.values();
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public void create(User entity) {
        entity.setId(id.incrementAndGet());
        update(entity);
    }

    @Override
    public void update(User entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public void delete(User entity) {
        map.remove(entity.getId());
    }
}
