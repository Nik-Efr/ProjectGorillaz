package com.javarush.efremov.cmd;

import com.javarush.efremov.config.Winter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class StartPageIT extends BaseIT {
private final StartPage startPage = Winter.find(StartPage.class);
    @Test
    @DisplayName("when open page then command return JspPage")
    void whenOpenPageThenCommandReturnJspPage() {
        String view = startPage.doGet(request);
        Assertions.assertEquals("start-page", view);
    }
}