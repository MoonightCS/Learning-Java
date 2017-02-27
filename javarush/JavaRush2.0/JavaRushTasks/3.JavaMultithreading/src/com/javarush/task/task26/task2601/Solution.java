package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.

Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13

Отсортированный масив:
13, 15, 17, 8, 5
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
                // return (x < y) ? -1 : ((x == y) ? 0 : 1);
            }
        });
        int middle = list.size() / 2;
        int median;
        if (list.size() % 2 == 1) {
            median = list.get(middle);
        } else {
            median = (list.get(middle - 1) + list.get(middle)) / 2;
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - median) - Math.abs(o2 - median);
            }
        }.thenComparing(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }));
        array = list.toArray(new Integer[list.size()]);
        return array;
    }
}
