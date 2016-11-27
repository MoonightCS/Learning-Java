package ru.popov.bodya;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Iterator;

import static org.junit.Assert.*;

public class MockitoSimpleTest {

    @Test
    public void iterator_will_return_hello_world() {
        Iterator iterator = Mockito.mock(Iterator.class);
        Mockito.when(iterator.next()).thenReturn("Hello").thenReturn("World");
        String result = iterator.next() + " " + iterator.next();
        assertEquals("Hello World", result);
    }

    @Test
    public void with_arguments() {
        Comparable c = Mockito.mock(Comparable.class);
        Mockito.when(c.compareTo("test")).thenReturn(1);
        assertEquals(1, c.compareTo("test"));
    }

    @Test
    public void with_unspecified_arguments() {
        Comparable c = Mockito.mock(Comparable.class);
        Mockito.when(c.compareTo(Mockito.anyInt())).thenReturn(-1);
        assertEquals(-1, c.compareTo(5));
    }

    @Test(expected = IOException.class)
    public void rethrowing_exception() throws IOException{
        OutputStream mock = Mockito.mock(OutputStream.class);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(mock);
        Mockito.doThrow(new IOException()).when(mock).close();
        outputStreamWriter.close();
    }

    @Test
    public void checkingMock() throws IOException{
        OutputStream mock = Mockito.mock(OutputStream.class);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(mock);
        outputStreamWriter.close();
        Mockito.verify(mock).close();
    }



}