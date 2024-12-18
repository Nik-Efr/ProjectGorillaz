package com.javarush.efremov.cmd;

import com.javarush.efremov.entity.User;
import com.javarush.efremov.service.UserService;
import com.javarush.efremov.util.Key;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

import java.util.Collection;

@SuppressWarnings("unused")
@AllArgsConstructor
public class ListUser implements Command {

    private final UserService userService;

    @Override
    public String doGet(HttpServletRequest request) {
        Collection<User> users = userService.getAll();
        request.setAttribute(Key.USERS, users);
        return getView();
    }


}