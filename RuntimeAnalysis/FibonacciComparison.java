public class FibonacciComparison {
    public static void main(String[] args) {
        int n = 30;

        long startTime, endTime;

        startTime = System.nanoTime();
        int recursiveResult = fibonacciRecursive(n);
        endTime = System.nanoTime();
        System.out.println("Recursive Fibonacci Result: " + recursiveResult);
        System.out.println("Recursive Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        int iterativeResult = fibonacciIterative(n);
        endTime = System.nanoTime();
        System.out.println("Iterative Fibonacci Result: " + iterativeResult);
        System.out.println("Iterative Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

