package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution {
    public static void main(String[] args) {
        String string = "МамаМылаРаму";
        permutation(string);

    }

    public static void permutation(String str) {
        permutation("", str, str.length());
    }

    private static void permutation(String prefix, String str, int length) {
        int n = length;
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i += 4)
                permutation(prefix + str.substring(i, i + 4), str.substring(0, i) + str.substring(i + 4, str.length()), length - 4);
        }
    }


}