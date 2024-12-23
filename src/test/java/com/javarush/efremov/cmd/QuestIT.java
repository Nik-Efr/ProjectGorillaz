package com.javarush.efremov.cmd;

import com.javarush.efremov.config.Winter;
import com.javarush.efremov.service.QuestService;
import com.javarush.efremov.util.Key;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class QuestIT extends BaseIT{
private final Quest quest = Winter.find(Quest.class);
private final QuestService questService = mock(QuestService.class);


    @Test
    @DisplayName("when click on quest then get Jsp page ")
    void whenClickOnQuestThenGetJspPage() {
        Mockito.when(request.getParameter(Key.ID)).thenReturn("1");
        Mockito.when(session.getAttribute(Key.QUEST_STEP)).thenReturn(null);
        String view = quest.doGet(request);
        verify(session).setAttribute(eq(Key.QUEST_STEP),eq(Key.START));
        Assertions.assertEquals(view,"quest");
    }

}