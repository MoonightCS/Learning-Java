package ru.popov.bodya.generics;

import java.util.ArrayList;
import java.util.List;

public class Reduce {

    static <E> E reduce(List<E> list, Function<E> f, E initVal) {
        List<E> snapshot;
        synchronized (list) {
            snapshot = new ArrayList<E>(list);
        }
        E result = initVal;
        for (E e: snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }

    interface Function<E> {
        E apply(E arg1, E arg2);
    }
}
