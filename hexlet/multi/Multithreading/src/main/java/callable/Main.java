package callable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newWorkStealingPool(3);
        final Callable sum = new SumCallable(1, 2);
        final Future<?> future  = executorService.submit(sum);
        System.out.println(future.get());

    }
}
