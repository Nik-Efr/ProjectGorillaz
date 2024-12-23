package com.javarush.efremov.cmd;

import com.javarush.efremov.config.Winter;
import com.javarush.efremov.repository.UserRepository;
import com.javarush.efremov.util.Go;
import com.javarush.efremov.util.Key;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SignupIT extends BaseIT {

    private final Signup signup = Winter.find(Signup.class);
    private final UserRepository repository = Winter.find(UserRepository.class);
    @Test
    @DisplayName("when click on signup then go to profile")
    void whenClickOnSignupThenGoToProfile() {
        Mockito.when(request.getParameter(Key.LOGIN)).thenReturn("TestLogin");
        Mockito.when(request.getParameter(Key.PASSWORD)).thenReturn("TestPassword");
        Mockito.when(request.getParameter(Key.ROLE)).thenReturn("GUEST");

        String uri = signup.doPost(request);
        Assertions.assertEquals(Go.PROFILE, uri);
        Assertions.assertTrue(repository.getAll().toString().contains("TestLogin"));
    }
}