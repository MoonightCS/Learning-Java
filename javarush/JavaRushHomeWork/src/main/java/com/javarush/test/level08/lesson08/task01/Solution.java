package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution {
    public static HashSet<String> createSet() {
        HashSet<String> strings = new HashSet<>();
        strings.add("Л");
        strings.add("ЛЛ");
        strings.add("ЛЛЛ");
        strings.add("ЛЛЛЛ");
        strings.add("ЛЛЛЛЛ");
        strings.add("ЛЛЛЛЛЛ");
        strings.add("ЛЛЛЛЛЛЛ");
        strings.add("ЛЛЛЛЛЛЛЛ");
        strings.add("ЛЛЛЛЛЛЛЛЛ");
        strings.add("ЛДДДДДДДД");
        strings.add("ЛЛЛЛДДДД");
        strings.add("ЛЛЛЛДДД");
        strings.add("ЛЛЛЛДД");
        strings.add("ЛЛЛЛД");
        strings.add("ЛЛЛЛ");
        strings.add("ЛЛЛ");
        strings.add("ЛЛЛ");
        strings.add("ЛЛЛasda");
        strings.add("ЛЛadsd");
        strings.add("ЛЛadsdasdas");
        strings.add("ЛДв");
        strings.add("ЛДввы");
        strings.add("ЛДвд");
        System.out.println(strings.size());
        return strings;
    }
}
