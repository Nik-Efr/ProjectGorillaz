package com.javarush.lesson12.hibernate;

import com.javarush.khmelov.entity.AbstractEntity;
import com.javarush.khmelov.entity.Game;
import com.javarush.khmelov.entity.Quest;
import com.javarush.khmelov.entity.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@ToString
public class Person implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    AuthData authData;

    @Enumerated(EnumType.STRING)
    private Role role;

}
