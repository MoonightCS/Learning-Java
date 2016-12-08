package ru.popov.bodya.mysoltuions;

public class ThreadHelper {

    public static int fib(final int numberToCalculate) throws Exception {
        final FibCalculator calculator = new FibCalculator(numberToCalculate);
        calculator.start();
        calculator.join();
        return calculator.getResult();
    }

    private static class FibCalculator extends Thread {

        int result = 0;
        int n;

        public FibCalculator(final int numberToCalculate) {
            this.n = numberToCalculate;
        }

        public int getResult() {
            return result;
        }

        @Override
        public void run() {
            result = fibo(0, 1, n);
        }

        private int fibo(int a, int b, int n) {
            if (n == 0)
                return a;
            return fibo(b, a + b, n - 1);
        }

    }
}
