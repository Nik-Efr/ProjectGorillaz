package com.javarush.efremov.cmd;

import com.javarush.efremov.entity.Role;
import com.javarush.efremov.entity.User;
import com.javarush.efremov.entity.UserStatistics;
import com.javarush.efremov.repository.UserRepository;
import com.javarush.efremov.service.ImageService;
import com.javarush.efremov.service.UserService;
import com.javarush.efremov.util.Go;
import com.javarush.efremov.util.Key;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@SuppressWarnings("unused")
@AllArgsConstructor
public class Signup implements Command {

    private final UserService userService;
    private final ImageService imageService;

    @Override
    @SneakyThrows
    public String doPost(HttpServletRequest request) {
        User user = User.builder()
                .login(request.getParameter(Key.LOGIN))
                .password(request.getParameter(Key.PASSWORD))
                .role(Role.USER)
                .build();
        userService.create(user);
        userService.createUserStatistics(user);
        imageService.uploadImage(request, user.getImage());
        HttpSession session = request.getSession();
        session.setAttribute(Key.USER, user);
        return Go.PROFILE;
    }
}
