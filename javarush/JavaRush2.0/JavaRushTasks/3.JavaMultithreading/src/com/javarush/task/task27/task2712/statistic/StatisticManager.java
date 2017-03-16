package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1. Внутри StatisticStorage создай метод void put(EventDataRow data).

2. Чтобы методом put(EventDataRow data) добавить объект data в данные карты, нужен тип события — EventType.
Будет правильно, если событие будет хранить в себе свой тип. Поэтому:
2.1. В интерфейс EventDataRow добавь метод EventType getType()
2.2. Реализуй этот метод в каждом классе-событии: CookedOrderEventDataRow, NoAvailableVideoEventDataRow, VideoSelectedEventDataRow

3. Сделай так, чтобы к методу void put(EventDataRow data) нельзя было получить доступ за пределами класса StatisticManager.
Воспользуйся особенностями вложенных классов.

Теперь остается расставить вызовы StatisticManager в те места, которые генерируют события.

4. Зарегистрируй событие для повара во время приготовления еды.
Добавь геттер для поля dishes в класс Order, используйте его при создании события.

5. Зарегистрируй событие «видео выбрано» перед отображением рекламы пользователю.

6. Метод register с одним параметром типа EventDataRow должен регистрировать полученное событие в statisticStorage.


 */

public class StatisticManager {

    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

    }


}
