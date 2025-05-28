package com.javarush.efremov.cmd;

import com.javarush.efremov.entity.User;
import com.javarush.efremov.service.UserService;
import com.javarush.efremov.util.Go;
import com.javarush.efremov.util.Key;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

import java.util.Optional;

@SuppressWarnings("unused")
@AllArgsConstructor
public class Login implements Command {

    private final UserService userService;

    @Override
    public String doPost(HttpServletRequest request) {
        String login = request.getParameter(Key.LOGIN);
        String password = request.getParameter(Key.PASSWORD);
        Optional<User> user = userService.get(login, password);
        if (user.isPresent()) {
            HttpSession session = request.getSession();
            session.setAttribute(Key.USER, user.get());
            return Go.PROFILE;
        } else {
            return Go.LOGIN;
        }
    }
}
