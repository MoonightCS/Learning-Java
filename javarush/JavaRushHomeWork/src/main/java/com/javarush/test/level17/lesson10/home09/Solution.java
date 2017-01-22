package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    static {
        readData();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {

        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
            return;
        }
        for (String str : forRemoveLines) {
            if (!allLines.contains(str)) {
                allLines.clear();
                throw new CorruptedDataException();
            }

        }
    }

    private static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine().trim();
            String fileName2 = reader.readLine().trim();
            reader.close();

            BufferedReader finalReader = new BufferedReader(new FileReader(fileName1));
            String tmp;
            while ((tmp = finalReader.readLine()) != null) {
                allLines.add(tmp);
            }
            finalReader.close();

            finalReader = new BufferedReader(new FileReader(fileName2));
            while ((tmp = finalReader.readLine()) != null) {
                forRemoveLines.add(tmp);
            }
            finalReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
