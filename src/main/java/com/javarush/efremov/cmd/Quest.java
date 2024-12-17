package com.javarush.efremov.cmd;

import com.javarush.efremov.service.QuestService;
import com.javarush.efremov.util.Go;
import com.javarush.efremov.util.Key;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Quest implements Command {

    private final QuestService questService;

    public Quest(QuestService questService) {
        this.questService = questService;
    }

    @Override
    public String doGet(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String currentStep = (String) session.getAttribute(Key.QUEST_STEP);

        if (currentStep == null) {
            currentStep = Key.START;
            session.setAttribute(Key.QUEST_STEP, currentStep);
        }

        String question = questService.getQuestion(currentStep);
        String[] options = questService.getOptions(currentStep);

        req.setAttribute(Key.QUESTION, question);
        req.setAttribute(Key.OPTIONS, options);

        return getView();
    }

    @Override
    public String doPost(HttpServletRequest req) {
        String answer = req.getParameter(Key.ANSWER);
        HttpSession session = req.getSession();
        String currentStep = (String) session.getAttribute(Key.QUEST_STEP);

        String nextStep = questService.getNextStep(currentStep, answer);

        if (nextStep=="/"){
            session.removeAttribute(Key.QUEST_STEP);
            return "/";
        }

        session.setAttribute(Key.QUEST_STEP, nextStep);

        return getView();
    }
}
