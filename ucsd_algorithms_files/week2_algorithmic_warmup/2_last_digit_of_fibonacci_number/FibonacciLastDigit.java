import java.util.*;

public class FibonacciLastDigit {
    private static boolean TESTING = false;
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    private static long getFibonacciLastDigit(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous % 10;
            previous = current % 10;
            current = tmp_previous + current % 10;
        }

        return current % 10;
    }


    public static void main(String[] args) {

        if (TESTING) {
            assertEquals("3", getFibonacciLastDigit(3), 2);
            assertEquals("239", getFibonacciLastDigit(239), 1);
            assertEquals("331", getFibonacciLastDigit(331), 9);
            assertEquals("327305", getFibonacciLastDigit(327305), 5);
        }
        else {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            long c = getFibonacciLastDigit(n);
            System.out.println(c);
        }
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
