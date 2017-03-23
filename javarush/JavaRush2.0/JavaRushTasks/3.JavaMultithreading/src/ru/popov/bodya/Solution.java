package ru.popov.bodya;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static class A {
        public static final B b = new B();
    }

    static class B {
        public static final A a = new A();
    }

    public static void main(String[] args) {

    }


}