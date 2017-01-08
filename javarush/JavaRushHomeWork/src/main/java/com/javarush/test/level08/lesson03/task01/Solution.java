package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        Set<String> set = new HashSet<>(Arrays.asList("арбуз", "банан", "вишня", "груша", "дыня", "ежевика",
                "жень-шень", "земляника", "ирис", "картофель"));
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
