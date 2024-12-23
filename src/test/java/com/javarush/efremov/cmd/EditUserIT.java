package com.javarush.efremov.cmd;

import com.javarush.efremov.config.Winter;
import com.javarush.efremov.entity.Role;
import com.javarush.efremov.entity.User;
import com.javarush.efremov.service.UserService;
import com.javarush.efremov.util.Key;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;

class EditUserIT extends BaseIT {

    private final EditUser editUser = Winter.find(EditUser.class);
    private final UserService userService = Winter.find(UserService.class);

    @Test
    @DisplayName("when open page then command return JspPage")
    void whenOpenPageThenCommandReturnJspPage() {
        User user = userService.getAll().stream().findFirst().orElseThrow();
        Mockito.when(request.getParameter(Key.ID)).thenReturn(user.getId().toString());
        String view = editUser.doGet(request);
        assertEquals("edit-user", view);
        verify(request).setAttribute(eq(Key.USER), eq(user));
    }

    @Test
    @DisplayName("when update user then get page by user id")
    void whenUpdateUserThenGetPageByUserId() {
        Mockito.when(request.getParameter(Key.LOGIN)).thenReturn("Name");
        Mockito.when(request.getParameter(Key.PASSWORD)).thenReturn("Password");
        Mockito.when(request.getParameter(Key.ROLE)).thenReturn(Role.GUEST.toString());
        Mockito.when(request.getParameter(Key.ID)).thenReturn("1");
        String page = editUser.doPost(request);
        assertTrue(page.endsWith("?id=1"));
    }
}