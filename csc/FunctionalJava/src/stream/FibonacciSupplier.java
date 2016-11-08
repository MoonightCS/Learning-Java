package stream;

import java.util.function.Supplier;

public class FibonacciSupplier implements Supplier<Integer>{

    private Integer prev = new Integer(0);
    private Integer next = new Integer(1);

    @Override
    public Integer get() {
        Integer current = next;
        next = prev + current;
        prev = current;
        return current;
    }
}
