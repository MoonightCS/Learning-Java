package ru.popov.bodya;

public class Main {

    static {
        System.out.println("static 1");
    }
    private final static String str;

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println(str);

    }

    static {
        str = "das";
        System.out.println("static 2");
    }


}
