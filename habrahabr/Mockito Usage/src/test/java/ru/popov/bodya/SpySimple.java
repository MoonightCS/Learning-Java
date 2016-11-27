package ru.popov.bodya;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

public class SpySimple {

    @Test
    public void spy_usage() {
        List<String> list = new LinkedList<String>();
        List spy = Mockito.spy(list);

        Mockito.when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));
        System.out.println(spy.get(1));

        System.out.println(spy.size());

        //можем проверить
        Mockito.verify(spy).add("one");

        Mockito.verify(spy). add("two");
    }
}
