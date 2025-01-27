package com.javarush.lesson09;

import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SessionCreatorTest {

    @Test
    void getSession() {
        SessionCreator sessionCreator = new SessionCreator();
        Session session = sessionCreator.getSession();
        Assertions.assertNotNull(session);
    }
}