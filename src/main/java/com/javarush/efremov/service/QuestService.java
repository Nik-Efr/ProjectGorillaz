package com.javarush.efremov.service;

import java.util.HashMap;
import java.util.Map;

public class QuestService {

    private final Map<String, QuestStep> questSteps;

    public QuestService() {
        questSteps = new HashMap<>();
        initializeQuest();
    }

    private void initializeQuest() {
        questSteps.put("start", new QuestStep("Вы находитесь в темной комнате. Что вы делаете?",
                new String[]{"Ищу выключатель", "Кричу 'Есть кто-нибудь?'", "Пытаюсь открыть дверь"},
                Map.of("Ищу выключатель", "light",
                        "Кричу 'Есть кто-нибудь?'", "lost1",
                        "Пытаюсь открыть дверь", "lost2")));

        questSteps.put("light", new QuestStep("Вы включили свет. Перед вами дверь и окно. Куда вы пойдете?",
                new String[]{"К двери", "К окну"},
                Map.of("К двери", "door",
                        "К окну", "lost3")));

        questSteps.put("door", new QuestStep("Дверь заперта. Что вы делаете?",
                new String[]{"Сильно толкаю дверь", "Ищу ключ"},
                Map.of("Сильно толкаю дверь", "lost4",
                        "Ищу ключ", "unlockedDoor")));

        // Шаг для успешного открытия двери
        questSteps.put("unlockedDoor", new QuestStep("Дверь открыта! Вы выходите в коридор и видите выход на улицу! Вы свободны!",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", "start","Вернуться на главное меню","/")));

        // Шаг для выхода через окно
        questSteps.put("lost3", new QuestStep("Вы выбрались через окно, но упали и получили травму. Игра окончена.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", "start","Вернуться на главное меню","/")));

        // Проигрышные варианты
        questSteps.put("lost1", new QuestStep("Ваш крик никого не привлек, и вы остались в темноте. Игра окончена.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", "start","Вернуться на главное меню","/")));

        questSteps.put("lost2", new QuestStep("Вы слишком сильно толкнули дверь, и она не поддается. Игра окончена.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", "start","Вернуться на главное меню","/")));

        questSteps.put("lost4", new QuestStep("Вы сломали дверь, пытаясь ее открыть. Теперь вы не можете выбраться. Игра окончена.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", "start","Вернуться на главное меню","/")));
    }


    public String getQuestion(String step) {
        String question = questSteps.get(step).getQuestion();
        if (question == null) {
            throw new IllegalArgumentException("Некорректный вопрос квеста: " + question);
        }
        return question;
    }

    public String[] getOptions(String step) {
        String[] options = questSteps.get(step).getOptions();
        if (options == null) {
            throw new IllegalArgumentException("Некорректные варианты ответа квеста: " + options);
        }
        return options;
    }

    public String getNextStep(String currentStep, String answer) {
        QuestStep questStep = questSteps.get(currentStep);
        if (questStep == null) {
            throw new IllegalArgumentException("Некорректный шаг квеста: " + currentStep);
        }
        return questStep.getNextSteps().get(answer);
    }

    private static class QuestStep {
        private final String question;
        private final String[] options;
        private final Map<String, String> nextSteps;

        public QuestStep(String question, String[] options, Map<String, String> nextSteps) {
            this.question = question;
            this.options = options;
            this.nextSteps = nextSteps;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public Map<String, String> getNextSteps() {
            return nextSteps;
        }
    }
}
