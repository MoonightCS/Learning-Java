package com.javarush.test.level20.lesson04.task04;

import java.io.*;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution {
    /*public static void main(String[] args) throws IOException, ClassNotFoundException {

        String fileName  = "/Users/bogdanpopov/Desktop/learning-java/javarush/JavaRushHomeWork/src/test/resources/file1.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        ClassWithStatic classWithStatic = new ClassWithStatic();
        classWithStatic.i = 1;
        classWithStatic.j = 9;
        classWithStatic.writeExternal(objectOutputStream);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        ClassWithStatic classWithStatic1 = new ClassWithStatic();
        classWithStatic1.readExternal(objectInputStream);
        objectInputStream.close();

        System.out.println(classWithStatic.i);
        System.out.println(classWithStatic.j);
        System.out.println(ClassWithStatic.staticString);

        System.out.println("______________");
        System.out.println(classWithStatic1.i);
        System.out.println(classWithStatic1.j);
        System.out.println(ClassWithStatic.staticString);
    }*/
    public static class ClassWithStatic implements Serializable{
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        /*@Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(staticString);
            out.writeInt(i);
            out.writeInt(j);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            staticString = (String)in.readObject();
            i = in.readInt();
            j = in.readInt();
        }*/
    }
}
