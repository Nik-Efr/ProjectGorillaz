package com.javarush.efremov.cmd;

import com.javarush.efremov.config.Winter;
import com.javarush.efremov.entity.User;
import com.javarush.efremov.util.Key;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class LoginIT extends BaseIT{

    final Login login = Winter.find(Login.class);
    @Test
    @DisplayName("When login user then redirect to profile")
    void whenLoginUserThenRedirectToProfile() {
        when(request.getParameter("login")).thenReturn("Cat");
        when(request.getParameter("password")).thenReturn("12345");

        String actualRedirect = login.doPost(request);
        Assertions.assertEquals("/profile", actualRedirect);

        verify(session)
                .setAttribute(eq(Key.USER), any(User.class));
    }

    @Test
    @DisplayName("When incorrect login then redirect to login")
    void whenIncorrectLoginThenRedirectToLogin() {
        when(request.getParameter("login")).thenReturn("Cat");
        when(request.getParameter("password")).thenReturn("wrongPassword");

        String actualRedirect = login.doPost(request);
        Assertions.assertEquals("/login", actualRedirect);
    }
}