package com.javarush.efremov.cmd;

import com.javarush.efremov.entity.User;
import com.javarush.efremov.entity.UserStatistics;
import com.javarush.efremov.repository.UserRepository;
import com.javarush.efremov.service.QuestService;
import com.javarush.efremov.service.UserService;
import com.javarush.efremov.util.Key;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class Quest implements Command {

    private final QuestService questService;
    private final UserService userService;

    public Quest(QuestService questService, UserService userService) {
        this.questService = questService;
        this.userService = userService;
    }

    @Override
    public String doGet(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        String currentStep = (String) session.getAttribute(Key.QUEST_STEP);

        if (currentStep == null) {
            currentStep = Key.START;
            session.setAttribute(Key.QUEST_STEP, currentStep);
        }

        String question = questService.getQuestion(currentStep, id);
        String[] options = questService.getOptions(currentStep, id);
        String imageUrl = questService.getImageUrl(currentStep,id);

        req.setAttribute(Key.QUESTION, question);
        req.setAttribute(Key.OPTIONS, options);
        req.setAttribute("imageUrl", imageUrl);

        return getView();
    }

    @Override
    public String doPost(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        String answer = req.getParameter(Key.ANSWER);
        HttpSession session = req.getSession();
        String currentStep = (String) session.getAttribute(Key.QUEST_STEP);

        String nextStep = questService.getNextStep(currentStep, answer, id);

        if (nextStep == "/") {
            session.removeAttribute(Key.QUEST_STEP);
            return "/";
        }else if(session.getAttribute("user")!=null){
            User user = (User) session.getAttribute("user");
            userService.updateUserStatistics(user,nextStep);
        }

        session.setAttribute(Key.QUEST_STEP, nextStep);
        String imageUrl = questService.getImageUrl(nextStep,id);
        req.setAttribute("imageUrl", imageUrl);

        return getView() + "?id=" + id;
    }
}
