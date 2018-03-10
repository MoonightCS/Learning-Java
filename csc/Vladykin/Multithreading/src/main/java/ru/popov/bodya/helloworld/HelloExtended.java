package ru.popov.bodya.helloworld;

public class HelloExtended {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new HelloThread().start();
        }
        System.out.println("Hello from main thread");
    }

    private static class HelloThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + this.getName());
        }
    }


}
