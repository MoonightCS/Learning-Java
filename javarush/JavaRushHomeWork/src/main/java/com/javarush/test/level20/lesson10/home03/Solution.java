package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static class A {
        protected String name = "A";

        public A() {
        }

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(name);
        }

        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            name = (String) stream.readObject();
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String fileName = "src/test/resources/file1.txt";
        Solution solution = new Solution();
        Solution.B child = solution.new B("its B");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(child);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        Solution.B loaded;
        loaded = (Solution.B) objectInputStream.readObject();
        System.out.println(loaded.name);

    }
}
