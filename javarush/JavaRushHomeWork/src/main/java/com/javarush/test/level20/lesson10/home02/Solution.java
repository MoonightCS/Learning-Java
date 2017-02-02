package com.javarush.test.level20.lesson10.home02;

import java.io.*;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException {
        A wild = (A) objectStream.readObject();
        if (wild instanceof B) return wild;
        return wild;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution();
        Solution.A b = solution.new B();
        try {
            final String fileName = "src/test/resources/file1.txt";
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(b);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            Solution.A loaded = solution.new A();
            loaded = solution.getOriginalObject(objectInputStream);
            objectInputStream.close();

        } catch (IOException io) {
            io.printStackTrace();
        } catch (ClassNotFoundException classNotFound) {
            System.out.println("class not found");
        }
    }
}
