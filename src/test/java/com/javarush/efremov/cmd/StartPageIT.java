package com.javarush.efremov.cmd;

import com.javarush.efremov.config.Winter;
import com.javarush.efremov.util.Key;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.mockito.Mockito.*;

class StartPageIT extends BaseIT {

    @Test
    @DisplayName("when open page then command return JspPage")
    void whenOpenPageThenCommandReturnJspPage() {
        StartPage startPage = Winter.find(StartPage.class);
        String view = startPage.doGet(request);
        Assertions.assertEquals("start-page", view);
    }
}