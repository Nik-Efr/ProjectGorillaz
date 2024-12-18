package com.javarush.efremov.cmd;

import com.javarush.efremov.entity.Role;
import com.javarush.efremov.entity.User;
import com.javarush.efremov.service.ImageService;
import com.javarush.efremov.service.UserService;
import com.javarush.efremov.util.Key;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;


@SuppressWarnings("unused")
@AllArgsConstructor
public class EditUser implements Command {

    private final UserService userService;
    private final ImageService imageService;

    @Override
    public String doGet(HttpServletRequest req) {
        String stringId = req.getParameter(Key.ID);
        if (stringId != null) {
            long id = Long.parseLong(stringId);
            userService.get(id)
                    .ifPresent(user -> req.setAttribute(Key.USER, user));
        }
        return getView();
    }

    @Override
    @SneakyThrows
    public String doPost(HttpServletRequest req) {
        long id = Long.parseLong(req.getParameter(Key.ID));
        User user = User.builder()
                .id(id)
                .login(req.getParameter(Key.LOGIN))
                .password(req.getParameter(Key.PASSWORD))
                .role(Role.valueOf(req.getParameter(Key.ROLE)))
                .build();
        userService.update(user);
        HttpSession session = req.getSession();
        session.setAttribute(Key.USER, user);
        imageService.uploadImage(req, user.getImage());
        return getView() + "?id=" + user.getId();
    }
}