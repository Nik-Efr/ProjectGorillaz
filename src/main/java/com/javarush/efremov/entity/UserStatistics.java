package com.javarush.efremov.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserStatistics {
    private long id;
    private String login;
    private long wins;
    private long losses;

    public UserStatistics(long id, String login, long wins, long losses) {
        this.id = id;
        this.login = login;
        this.wins = wins;
        this.losses = losses;
    }

    public void increaseWins(){
        this.wins++;
    }
    public void increaseLosses(){
        this.losses++;
    }
}
