package com.javarush.efremov.cmd;

import com.javarush.efremov.config.Winter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogoutIT extends BaseIT {

    private final Logout logout = Winter.find(Logout.class);
    @Test
    @DisplayName("when open page then invalidate session")
    void whenOpenPageThenInvalidateSession() {
        logout.doGet(request);
        Mockito.verify(session).invalidate();
    }

}