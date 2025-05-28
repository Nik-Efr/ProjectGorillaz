package com.javarush.efremov.cmd;

import com.javarush.efremov.config.Winter;
import com.javarush.efremov.util.Key;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ListUserIT extends BaseIT {

    ListUser listUser = Winter.find(ListUser.class);
    @Test
    @DisplayName("when get list users then return jsp page")
    void whenGetListUsersThenReturnJspPage() {
        String jspPage = listUser.doGet(request);

        assertEquals("list-user", jspPage);
        verify(request).setAttribute(eq(Key.USERS), any(Collection.class));
    }
}