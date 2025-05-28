package com.javarush.efremov.cmd;

import com.javarush.efremov.config.Winter;
import com.javarush.efremov.util.Go;
import com.javarush.efremov.util.Key;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProfileIT extends BaseIT {

    private final Profile profile = Winter.find(Profile.class);

    @Test
    @DisplayName("when click edit in profile then go to edit user page")
    void whenClickEditInProfileThenGoToEditUserPage() {
        Mockito.when(session.getAttribute(Key.USER)).thenReturn(testUser);
        String uri = profile.doPost(request);
        Assertions.assertEquals(Go.EDIT_USER + "?id=" + testUser.getId(), uri);
    }

    @Test
    @DisplayName("when click logout then go logout")
    void whenClickLogoutThenGoLogout() {
        Mockito.when(request.getParameter(Key.LOGOUT)).thenReturn("true");
        String uri = profile.doPost(request);
        Assertions.assertEquals(Go.LOGOUT, uri);
    }
}