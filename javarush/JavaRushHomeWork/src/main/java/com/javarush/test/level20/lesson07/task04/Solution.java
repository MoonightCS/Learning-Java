package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable {

    public static void main(String[] args) {
        try {
            final String fileName = "/Users/bogdanpopov/Desktop/learning-java/javarush/JavaRushHomeWork/src/test/resources/file1.txt";
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            Solution savedObject = new Solution(20);
            objectOutputStream.writeObject(savedObject);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            Solution loadedObject = new Solution(19);
            loadedObject = (Solution) objectInputStream.readObject();
            System.out.println(savedObject.toString().equals(loadedObject.toString()));
            objectInputStream.close();
            System.out.println(savedObject.toString());
        } catch (IOException io) {
            System.out.println("something wrong with IO");
        } catch (ClassNotFoundException classNotFound) {
            System.out.println("class not found");
        }

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
