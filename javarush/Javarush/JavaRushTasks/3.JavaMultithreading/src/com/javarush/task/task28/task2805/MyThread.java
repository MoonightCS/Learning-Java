package com.javarush.task.task28.task2805;

/*
Приоритеты в Threads
В отдельном файле создай класс MyThread унаследовавшись от Thread. MyThread должен:
1. Иметь возможность быть созданным используя любой конструктор супер-класса (Alt+Insert).
2. Приоритет у трэдов должен проставляться циклично от минимального значения до максимального значения.
3. если у трэда установлена трэд-группа(ThreadGroup), то приоритет трэда не может быть больше максимального приоритета его трэд-группы.
*/


public class MyThread extends Thread {

    //output
    //1 2 3 4 5 6 7 8 9 10 1 2

    //output
    //3 4 5 6 7 7 7 7 1 2 3 4

    private static int priority = 0;


    private void initialize() {

        if (++priority == 11) {
            priority = 1;
        }

        int localPriority = priority;
        if (getThreadGroup() != null) {
            if (localPriority > getThreadGroup().getMaxPriority()) {
                localPriority = getThreadGroup().getMaxPriority();
            }
        }
        this.setPriority(localPriority);
    }


    public MyThread() {
        initialize();
    }

    public MyThread(Runnable target) {
        super(target);
        initialize();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        initialize();
    }

    public MyThread(String name) {
        super(name);
        initialize();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        initialize();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        initialize();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        initialize();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        initialize();
    }
}
