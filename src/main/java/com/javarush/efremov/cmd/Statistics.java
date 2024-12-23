package com.javarush.efremov.cmd;

import com.javarush.efremov.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Statistics implements Command{
    UserRepository repository;
    @Override
    public String doGet(HttpServletRequest req) {
        req.setAttribute("statistics", repository.getAllUserStatistics());
        return getView();
    }
}
