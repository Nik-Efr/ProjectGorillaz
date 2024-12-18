package com.javarush.efremov.cmd;

import com.javarush.efremov.entity.User;
import com.javarush.efremov.util.Go;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("unused")
public class Profile implements Command {

    @Override
    public String doPost(HttpServletRequest request) {
        if (request.getParameter("logout") == null) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            return Go.EDIT_USER + "?id=" + user.getId();
        } else {
            return Go.LOGOUT;
        }
    }
}
