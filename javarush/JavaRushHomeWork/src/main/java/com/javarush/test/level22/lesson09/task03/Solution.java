package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    private static StringBuilder result = null;

    public static void main(String[] args) throws Exception {

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        ) {
            ArrayList<String> list = new ArrayList<>();
            while (fileReader.ready()) {
                list.addAll(Arrays.asList(fileReader.readLine().split(" ")));
            }
            String[] strings = new String[list.size()];
            StringBuilder result = getLine(list.toArray(strings));
            System.out.println(result == null ? "" : result.toString());
        }
    }


    public static StringBuilder getLine(String... words) {
        Set<String> cities = new HashSet<>();
        Collections.addAll(cities, words);
        nextCity(new StringBuilder(), cities);
        return result;
    }

    private static boolean nextCity(StringBuilder sb, Set<String> set) {

        Set<String> mutableSet = new HashSet<>(set);
        boolean status;

        if (set.size() == 0) {
            result = sb;
            return true;
        }

        if (sb.length() == 0) {
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                sb.append(next);
                mutableSet.remove(next);
                if (nextCity(sb, mutableSet)) {
                    return true;
                } else {
                    mutableSet.add(next);
                    sb = new StringBuilder();
                }
            }
        }


        for (String next : set) {
            if (checkCityWithBuilder(next, sb)) {
                mutableSet.remove(next);
                status = nextCity(sb, mutableSet);
                if (status) {
                    return true;
                } else {
                    mutableSet.add(next);
                }
            }
        }
        return false;
    }

    private static boolean checkCityWithBuilder(String cityName, StringBuilder sb) {
        String tmp = cityName.toLowerCase();
        String base = sb.toString().toLowerCase();
        if (tmp.charAt(0) == base.charAt(base.length() - 1)) {
            sb.append(" ").append(cityName);
            return true;
        } else if (base.charAt(0) == tmp.charAt(tmp.length() - 1)) {
            sb.insert(0, cityName + " ");
            return true;
        }
        return false;
    }
}




