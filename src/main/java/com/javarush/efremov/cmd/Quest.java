package com.javarush.efremov.cmd;

import com.javarush.efremov.service.QuestService;
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
        String currentStep = (String) session.getAttribute("questStep");

        if (currentStep == null) {
            currentStep = "start";
            session.setAttribute("questStep", currentStep);
        } else if (currentStep=="/"){
            session.removeAttribute("questStep");
            return "start-page";
        }

        String question = questService.getQuestion(currentStep);
        String[] options = questService.getOptions(currentStep);

        req.setAttribute("question", question);
        req.setAttribute("options", options);

        return getView();
    }

    @Override
    public String doPost(HttpServletRequest req) {
        String answer = req.getParameter("answer");
        HttpSession session = req.getSession();
        String currentStep = (String) session.getAttribute("questStep");

        String nextStep = questService.getNextStep(currentStep, answer);
        session.setAttribute("questStep", nextStep);

        return getView();
    }
}
