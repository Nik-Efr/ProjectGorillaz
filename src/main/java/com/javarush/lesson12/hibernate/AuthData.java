package com.javarush.lesson12.hibernate;

import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.NamedQueries;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class AuthData {
    private String login;

    @Convert(converter = PasswordConverter.class)
    private Password password;
}
