import java.util.HashMap;
import java.util.Map;

public class FibonacciAlgorithm {

    // Iterative method
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }

    // Recursive method
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Memoization (Dynamic Programming) method
    public static int fibonacciMemoization(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return fibonacciMemoizationHelper(n, memo);
    }

    private static int fibonacciMemoizationHelper(int n, Map<Integer, Integer> memo) {
        if (n <= 1)
            return n;
        if (memo.containsKey(n))
            return memo.get(n);
        int fib = fibonacciMemoizationHelper(n - 1, memo) + fibonacciMemoizationHelper(n - 2, memo);
        memo.put(n, fib);
        return fib;
    }

    public static void main(String[] args) {
        int n = 10; // Change n to calculate different Fibonacci numbers
        System.out.println("Iterative: " + fibonacciIterative(n));
        System.out.println("Recursive: " + fibonacciRecursive(n));
        System.out.println("Memoization: " + fibonacciMemoization(n));
    }
}
