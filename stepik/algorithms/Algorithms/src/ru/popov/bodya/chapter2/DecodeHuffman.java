package ru.popov.bodya.chapter2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DecodeHuffman {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int length = scanner.nextInt();
        final Map<String, Character> huffmanCodesMap = new HashMap<>();


        for (int i = 0; i < n; i++) {
            final String charStr = scanner.next();
            final char[] chars = charStr.trim().toCharArray();
            final String freq = scanner.next();
            huffmanCodesMap.put(freq, chars[0]);
        }
        final char[] charArray = scanner.next().toCharArray();
        StringBuilder resultStringBuilder = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        for (char ch: charArray) {
            tmp.append(String.valueOf(ch));
            final Character character = huffmanCodesMap.get(tmp.toString());
            if (character != null) {
                resultStringBuilder.append(character);
                tmp = new StringBuilder();
            }
        }
        System.out.println(resultStringBuilder.toString());
    }
}
