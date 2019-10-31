import java.util.*;
//import java.math.BigInteger;

public class FibonacciHuge {

    private static boolean TESTING = true;

    private static long getFibonacciMod(long n, int m) {

        // Basic Strategy
        if (n <= 1) {
            return n;
        }
        else {
            // Initialize Fibs and mods
            long previous = 0;
            long current  = 1;

            for (int i = 0; i < n; ++i) {
                long tmp_previous = previous;
                previous = current;
                current = tmp_previous + current;
            }

            return 42;
        }
    }

    public static void main(String[] args) {
        if (TESTING) {
            assertEquals("1", getFibonacciMod(1, 2), 1);
            assertEquals("2", getFibonacciMod(2, 2), 1);
            assertEquals("3", getFibonacciMod(3, 2), 0);
            //assertEquals("239", getFibonacciMod(239, 1000), 161);
        }
        else {
            Scanner scanner = new Scanner(System.in);
            long n = scanner.nextLong();
            int m = scanner.nextInt();
            System.out.println(getFibonacciMod(n, m));
        }
    }

    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    public static void assertEquals(String testName, long function, long result) {
        if (function == result) {
            System.out.println(".");
        }
        else {
            System.out.println(
                "FAIL: " + testName + " expected " + result + ", got " + function + ".");
        }
    }

}
