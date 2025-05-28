package com.javarush.efremov.service;

import com.javarush.efremov.util.Key;

import java.util.HashMap;
import java.util.Map;

public class QuestService {

    private final Map<String, QuestStep> questSteps1;
    private final Map<String, QuestStep> questSteps2;
    private final Map<String, QuestStep> questSteps3;

    public QuestService() {
        questSteps1 = new HashMap<>();
        questSteps2 = new HashMap<>();
        questSteps3 = new HashMap<>();
        initializeQuests();
    }

    private void initializeQuests() {
        // first quest
        questSteps1.put("start", new QuestStep("Вы находитесь в темной комнате. Что вы делаете?",
                new String[]{"Ищу выключатель", "Кричу 'Есть кто-нибудь?'", "Пытаюсь найти выход"},
                Map.of("Ищу выключатель", "light",
                        "Кричу 'Есть кто-нибудь?'", "lost1",
                        "Пытаюсь найти выход", "lost2")));

        questSteps1.put("light", new QuestStep("Вы включили свет. Перед вами дверь и окно. Куда вы пойдете?",
                new String[]{"К двери", "К окну"},
                Map.of("К двери", "door",
                        "К окну", "lost3")));

        questSteps1.put("door", new QuestStep("Дверь заперта. Что вы делаете?",
                new String[]{"Сильно толкаю дверь", "Ищу ключ"},
                Map.of("Сильно толкаю дверь", "lost4",
                        "Ищу ключ", "win")));

        questSteps1.put("win", new QuestStep("Вы нашли ключ и открыли дверь! Вы выходите в коридор и видите выход на улицу! Вы свободны!",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        questSteps1.put("lost3", new QuestStep("Вы выбрались через окно, но упали и получили травму.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        questSteps1.put("lost1", new QuestStep("Ваш крик никого не привлек, и вы остались в темноте.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        questSteps1.put("lost2", new QuestStep("Вы не смогли найти выход из-за темноты.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        questSteps1.put("lost4", new QuestStep("Вы сломали дверь, пытаясь ее открыть. Теперь вы не можете выбраться.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        //second quest
        questSteps2.put("start", new QuestStep("Вы находитесь в лесу. Вокруг вас высокие деревья. Что вы делаете?",
                new String[]{"Сажусь отдохнуть", "Иду по тропинке", "Зову на помощь"},
                Map.of("Сажусь отдохнуть", "lost5",
                        "Иду по тропинке", "path",
                        "Зову на помощь", "lost6")));

        questSteps2.put("path", new QuestStep("Вы идете по тропинке и видите два пути: один ведет к реке, другой - в горы. Куда вы пойдете?",
                new String[]{"К реке", "В горы"},
                Map.of("В горы", "lost7",
                        "К реке", "river")));

        questSteps2.put("river", new QuestStep("Вы подошли к реке и увидели лодку. Что вы делаете?",
                new String[]{"Сажусь в лодку", "Поплыву без лодки"},
                Map.of("Сажусь в лодку", "win",
                        "Поплыву без лодки", "lost8")));

        questSteps2.put("win", new QuestStep("Вы переплыли реку на лодке и выбрались из леса! Вы спасены!",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        questSteps2.put("lost5", new QuestStep("В лесу потемнело и вы не смогли найти дорогу домой",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        questSteps2.put("lost6", new QuestStep("Ваши крики никого не привлекли, и вы остались один в лесу.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        questSteps2.put("lost7", new QuestStep("На пути в горы вы заблудились и не смогли найти дорогу назад.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        questSteps2.put("lost8", new QuestStep("Вам не хватило сил и вы утонули",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        //third quest
        questSteps3.put("start", new QuestStep("Вы оказались в старом замке. Внутри темно и тихо. Что вы делаете?",
                new String[]{"Исследую комнату", "Зову призрака", "Ищу факел"},
                Map.of("Исследую комнату", "lost9",
                        "Зову призрака", "lost10",
                        "Ищу факел", "torch")));

        questSteps3.put("torch", new QuestStep("Вы нашли факел и осветили комнату. Теперь вы видите две двери: одна ведет в подвал, другая - в библиотеку. Куда вы пойдете?",
                new String[]{"В подвал", "В библиотеку"},
                Map.of("В подвал", "lost11",
                        "В библиотеку", "win")));

        questSteps3.put("win", new QuestStep("В библиотеке много книг, но одна из них падает и открывает секретный проход! Вы нашли выход!",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        questSteps3.put("lost9", new QuestStep("Вы наткнулись на ловушку и попали в темницу.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        questSteps3.put("lost10", new QuestStep("Ваши крики разбудили призрака, который запер вас в замке навсегда.",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));

        questSteps3.put("lost11", new QuestStep("В подвале вы попадаете в ловушку и погибаете",
                new String[]{"Начать заново", "Вернуться на главное меню"},
                Map.of("Начать заново", Key.START, "Вернуться на главное меню", "/")));
    }


    public String getQuestion(String step, int id) {
        String question = null;
        switch (id) {
            case 1:
                question = questSteps1.get(step).getQuestion();
                break;
            case 2:
                question = questSteps2.get(step).getQuestion();
                break;
            case 3:
                question = questSteps3.get(step).getQuestion();
                break;
        }

        if (question == null) {
            throw new IllegalArgumentException("Некорректный вопрос квеста: " + question);
        }
        return question;
    }

    public String[] getOptions(String step, int id) {
        String[] options = null;
        switch (id) {
            case 1:
                options = questSteps1.get(step).getOptions();
                break;
            case 2:
                options = questSteps2.get(step).getOptions();
                break;
            case 3:
                options = questSteps3.get(step).getOptions();
                break;
        }

        if (options == null) {
            throw new IllegalArgumentException("Некорректные варианты ответа квеста: " + options);
        }
        return options;
    }

    public String getNextStep(String currentStep, String answer, int id) {
        QuestStep questStep = null;
        switch (id) {
            case 1:
                questStep = questSteps1.get(currentStep);
                break;
            case 2:
                questStep = questSteps2.get(currentStep);
                break;
            case 3:
                questStep = questSteps3.get(currentStep);
                break;
        }
        if (questStep == null) {
            throw new IllegalArgumentException("Некорректный шаг квеста: " + currentStep);
        }
        return questStep.getNextSteps().get(answer);
    }

    public String getImageUrl(String step, int id) {
        if (step.contains("lost")) {
            return "images/lost";
        } else if (step.contains("win")) {
            return "images/win";
        } else if (step.contains("start")) {
            return "images/start" + id;
        }
        return "images/" + step;
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
