package ru.popov.bodya;

public class ProThreadHelper {

    public static int fib(final int numberToCalculate) throws Exception {
        final ProFibCalculator calculator = new ProFibCalculator(numberToCalculate);
        calculator.start();
        calculator.join();
        return calculator.getResult();
    }

    private static class ProFibCalculator extends Thread {

        private final int currentNum;

        private int result;

        public ProFibCalculator(final int numberToCalculate) {
            this.currentNum = numberToCalculate;
        }

        @Override
        public void run() {
            if (currentNum == 1 || currentNum == 2) {
                result = 1;
                return;
            }
            final ProFibCalculator left = new ProFibCalculator(currentNum - 1);
            final ProFibCalculator right = new ProFibCalculator(currentNum - 2);
            left.start();
            right.start();
            try {
                left.join();
                right.join();
            } catch (final InterruptedException e) {
            }
            result = left.getResult() + right.getResult();
        }

        public int getResult() {
            return result;
        }
    }
}
