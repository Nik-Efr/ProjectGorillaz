package com.javarush.khmelov.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"questions"})
@NamedQueries({
        @NamedQuery(name = Quest.ID_LESS, query = "SELECT q FROM Quest q where q.id<:id"),
        @NamedQuery(name = Quest.ID_MORE, query = "SELECT q FROM Quest q where q.id>:id"),
        @NamedQuery(name = Quest.ID_BETWEEN, query = "SELECT q FROM Quest q where q.id>=:min and q.id<=:max"),
})

public class Quest implements AbstractEntity {
    public static final String ID_LESS = "ID_LESS";
    public static final String ID_MORE = "ID_MORE";
    public static final String ID_BETWEEN = "ID_BETWEEN";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String text;

    @Column(name = "users_id")
    private Long authorId;

    @Column(name = "start_question_id")
    private Long startQuestionId;

    @Transient
    private final Collection<Question> questions = new ArrayList<>();

}
