package com.javarush.task.task27.task2707;

/* 
Реализуй логику метода isNormalLockOrder, который должен определять:
соответствует ли порядок synchronized блоков в методе someMethodWithSynchronizedBlocks — порядку передаваемых в него аргументов.
В случае, если сначала происходит синхронизация по o1, а потом по o2, метод должен вернуть true.
Если наоборот — false.

Метод isNormalLockOrder должен возвращать true в случае, если синхронизация в методе
 someMethodWithSynchronizedBlocks происходит сначала по объекту o1, а потом по o2.

Метод isNormalLockOrder должен возвращать false в случае, если синхронизация в методе
someMethodWithSynchronizedBlocks происходит сначала по объекту o2, а потом по o1.
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }

            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread threadForTest = new Thread() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        };

        Thread thief = new Thread() {
            @Override
            public void run() {
                synchronized (o2) {
                }
            }
        };

        synchronized (o1) {
            threadForTest.start();
            thief.start();
        }
        Thread.sleep(30);
        return thief.getState() != Thread.State.BLOCKED;

    }


    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
