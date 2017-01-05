package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;
import java.util.List;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("String" + i);
        }
        int size = list.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }

    }
}
