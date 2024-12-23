package com.javarush.efremov.service;

import com.javarush.efremov.entity.UserStatistics;
import com.javarush.efremov.repository.UserRepository;
import com.javarush.efremov.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.create(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> get(long id) {
        return userRepository.get(id);
    }

    public Optional<User> get(String login, String password) {
        User patternUser = User
                .builder()
                .login(login)
                .password(password)
                .build();
        return userRepository.find(patternUser).findAny();
    }

    public void updateUserStatistics(User user, String nextStep) {
        for (UserStatistics stat : userRepository.getAllUserStatistics()) {
            if (stat.getId() == user.getId()) {
                if (nextStep.contains("win")) {
                    stat.increaseWins();
                } else if (nextStep.contains("lost")) {
                    stat.increaseLosses();
                }
            }
        }
    }

    public void updateUserStatistics(User user) {
        for (UserStatistics stat : userRepository.getAllUserStatistics()) {
            if (stat.getId() == user.getId()) {
                stat.setLogin(user.getLogin());
            }
        }
    }

    public void createUserStatistics(User user) {
        userRepository.getAllUserStatistics().add(new UserStatistics(user.getId(), user.getLogin(), 0,0));
    }

}
