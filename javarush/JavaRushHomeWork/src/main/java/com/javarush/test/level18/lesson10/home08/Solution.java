package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while ((fileName = reader.readLine()) != null) {
            Thread readThread = new ReadThread(fileName);
            readThread.start();
            try {
                readThread.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception :(");
            }
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            Map<Integer, Integer> countOfBytes = new HashMap<>();
            int max = 0;
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                while (inputStream.available() > 0) {
                    int tmp = inputStream.read();
                    if (countOfBytes.containsKey(tmp)) {
                        countOfBytes.put(tmp, countOfBytes.get(tmp) + 1);
                    } else {
                        countOfBytes.put(tmp, 1);
                    }
                    int value = countOfBytes.get(tmp);
                    if (value > max) {
                        max = value;
                    }
                }

                for (Map.Entry<Integer, Integer> entry : countOfBytes.entrySet()) {
                    if (entry.getValue() == max) {
                        synchronized (Solution.class) {
                            resultMap.put(fileName, entry.getKey());
                        }
                    }
                }
                inputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found :(");
            } catch (IOException e) {
                System.out.println("IO exception :(");
            }
        }

    }
}
