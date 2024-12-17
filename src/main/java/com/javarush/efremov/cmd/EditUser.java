package com.javarush.efremov.cmd;

import com.javarush.efremov.entity.Role;
import com.javarush.efremov.entity.User;
import com.javarush.efremov.service.UserService;
import com.javarush.efremov.util.Key;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;


@SuppressWarnings("unused")
public class EditUser implements Command {

    private final UserService userService;

    public EditUser(UserService userService) {
        this.userService = userService;
    }


    @Override
    public String doGet(HttpServletRequest req) {
        String stringId = req.getParameter(Key.ID);
        if (stringId != null) {
            long id = Long.parseLong(stringId);
            Optional<User> optionalUser = userService.get(id);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                req.setAttribute(Key.USER, user);
            }
        }
        return getView();
    }

    @Override
    public String doPost(HttpServletRequest req) {
        User user = User.builder()
                .login(req.getParameter(Key.LOGIN))
                .password(req.getParameter(Key.PASSWORD))
                .role(Role.valueOf(req.getParameter(Key.ROLE)))
                .build();
        if (req.getParameter("create") != null) {
            userService.create(user);
        } else if (req.getParameter("update") != null) {
            user.setId(Long.parseLong(req.getParameter(Key.ID)));
            userService.update(user);
        }
        return getView() + "?id=" + user.getId();
    }


}