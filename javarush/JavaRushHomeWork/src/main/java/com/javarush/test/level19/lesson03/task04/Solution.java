package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String[] personData = scanner.nextLine().split(" ");
            Calendar calendar = new GregorianCalendar(Integer.valueOf(personData[5]),
                    Integer.valueOf(personData[4]) - 1,
                    Integer.valueOf(personData[3]));
            return new Person(personData[1], personData[2], personData[0], calendar.getTime());
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
