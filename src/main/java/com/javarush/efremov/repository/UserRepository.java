package com.javarush.efremov.repository;

import com.javarush.efremov.entity.Role;
import com.javarush.efremov.entity.User;
import com.javarush.efremov.entity.UserStatistics;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class UserRepository implements Repository<User> {

    private final Map<Long, User> map = new HashMap<>();

    public static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    private final List<UserStatistics> userStatistics = new ArrayList<>();

    public UserRepository() {
        map.put(1L, new User(1L, "Avatar", "qwerty", Role.USER));
        map.put(2L, new User(2L, "Cat", "12345", Role.USER));
        map.put(3L, new User(3L, "Robz", "password", Role.USER));
        map.put(4L, new User(4L, "Admin", "admin", Role.ADMIN));

        userStatistics.add(new UserStatistics(1L, "Avatar", 0, 0));
        userStatistics.add(new UserStatistics(2L, "Cat", 0, 0));
        userStatistics.add(new UserStatistics(3L, "Robz", 0, 0));
        userStatistics.add(new UserStatistics(4L, "Admin", 0, 0));
    }

    public List<UserStatistics> getAllUserStatistics(){
        return userStatistics;
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

    public Stream<User> find(User pattern) {
        return map.values()
                .stream()
                .filter(u -> nullOrEquals(pattern.getId(), u.getId()))
                .filter(u -> nullOrEquals(pattern.getLogin(), u.getLogin()))
                .filter(u -> nullOrEquals(pattern.getPassword(), u.getPassword()))
                .filter(u -> nullOrEquals(pattern.getRole(), u.getRole()));
    }

    protected boolean nullOrEquals(Object patternField, Object repoField) {
        return patternField == null || patternField.equals(repoField);
    }
}
