package com.javarush.efremov.cmd;

import com.javarush.efremov.config.Winter;
import com.javarush.efremov.entity.UserStatistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

class StatisticsIT extends BaseIT{
    private final  Statistics statistics = Winter.find(Statistics.class);

    @Test
    @DisplayName("when click on statistics then go to Jsp page")
    void whenClickOnStatisticsThenGoToJspPage() {
        String view = statistics.doGet(request);
        Assertions.assertEquals(view, "statistics");
        verify(request).setAttribute(eq("statistics"), any(List.class));
    }

}