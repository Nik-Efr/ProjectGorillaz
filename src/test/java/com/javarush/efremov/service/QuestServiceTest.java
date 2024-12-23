package com.javarush.efremov.service;

import com.javarush.efremov.config.Winter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestServiceTest {
    QuestService questService = Winter.find(QuestService.class);
    @Test
    void shouldReturnCorrectQuestionForFirstStepOfQuest1() {
        String question = questService.getQuestion("start", 1);
        assertEquals("Вы находитесь в темной комнате. Что вы делаете?", question);
    }

    @Test
    void shouldReturnCorrectOptionsForFirstStepOfQuest2() {
        String[] expectedOptions = {"Сажусь отдохнуть", "Иду по тропинке", "Зову на помощь"};
        String[] actualOptions = questService.getOptions("start", 2);
        assertArrayEquals(expectedOptions, actualOptions);
    }

    @Test
    void testGetNextStepForQuest3() {
        String currentStep = "start";
        String answer = "Ищу факел";
        int questId = 3;

        String nextStep = questService.getNextStep(currentStep, answer, questId);

        assertEquals("torch", nextStep);
    }

    @Test
    void testGetImageUrlForLostStep() {
        String imageUrl = questService.getImageUrl("lost1", 1);
        assertEquals("images/lost", imageUrl);
    }

    @Test
    void shouldReturnCorrectImageUrlForWinStep() {
        String imageUrl = questService.getImageUrl("win", 1);
        assertEquals("images/win", imageUrl);
    }


}