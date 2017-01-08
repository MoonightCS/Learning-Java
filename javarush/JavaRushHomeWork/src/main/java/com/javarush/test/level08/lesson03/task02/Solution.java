package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - ягода, банан - трава, вишня - ягода, груша - фрукт, дыня - овощ, ежевика - куст, жень-шень - корень, земляника - ягода,
ирис - цветок, картофель - клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель - клубень
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<String, String> fruits = new HashMap<>();
        fruits.put("арбуз", "ягода");
        fruits.put("банан", "трава");
        fruits.put("вишня", "ягода");
        fruits.put("груша", "фрукт");
        fruits.put("дыня", "овощ");
        fruits.put("ежевика", "куст");
        fruits.put("жень-шень", "корень");
        fruits.put("земляника", "ягода");
        fruits.put("ирис", "цветок");
        fruits.put("картофель", "клубень");

        Iterator<Map.Entry<String,String>> mapIterator = fruits.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, String> pair = mapIterator.next();
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
