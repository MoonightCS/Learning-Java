package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }
        int firstTabIndex = string.indexOf("\t") + 1;
        int secondTabIndex = 0;


        char[] chars = string.toCharArray();
        for (int i = firstTabIndex; i < string.length(); i++) {
            if (chars[i] == '\t') {
                secondTabIndex = i;
                break;
            }
        }
        if (secondTabIndex == 0) {
            throw new TooShortStringException();
        }
        return string.substring(firstTabIndex, secondTabIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
