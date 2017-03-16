package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

public class StatisticManager {

    private final StatisticManager manager = new StatisticManager();

    private StatisticManager() {
    }

    public StatisticManager getStatisticManager() {
        return manager;
    }

    public void register(EventDataRow data) {

    }
}
