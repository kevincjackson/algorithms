import java.util.*;
import java.math.BigInteger;

public class FibonacciHuge {

    private static boolean TESTING = false;

    private static long getFibonacciModHuge(long n, int m) {
        return getFibMod(n, m);
    }

    public static long getFibMod(long n, int m) {
        if (n <= 1) {
            return n;
        }
        else {
            long previous = 0;
            long current  = 1;
            long temp;
            for (long i = 1; i < n; i+= 1) {
                temp = (previous + current) % m;
                previous = current;
                current = temp;
            }
            return current;
        }
    }

    // Returns 0 if unsuccessful or result > 0 if succesful
    public static long getCycle(int m) {
        long temp = 0;
        long previous = 0;
        long current = 1;
        long cycle = 0;
        long i = 1;

        while (true) {
              temp = previous % m;
              previous = current % m;
              current = (temp + current) % m;

              if (previous == 0 && current == 1) {
                  cycle = i;
                  break;
              }

              i += 1;
        }

        return cycle;
    }

    public static void main(String[] args) {
        if (TESTING) {
            assertEquals("1 mod2", getFibonacciModHuge(1, 2), 1);
            assertEquals("2 mod2", getFibonacciModHuge(2, 2), 1);
            assertEquals("3 mod2", getFibonacciModHuge(3, 2), 0);
            assertEquals("4 mod2", getFibonacciModHuge(4, 2), 1);
            assertEquals("5 mod2", getFibonacciModHuge(5, 2), 1);
            assertEquals("6 mod2", getFibonacciModHuge(6, 2), 0);
            assertEquals("10 mod2", getFibonacciModHuge(10, 2), 1);
            assertEquals("239", getFibonacciModHuge(239, 1000), 161);
        }
        else {
            // Get input n and m (modulo)
            Scanner scanner = new Scanner(System.in);
            String nString = scanner.next();
            int m = scanner.nextInt();

            // Need to get Big Integer down to long size.
            BigInteger nBig = new BigInteger(nString);

            // Need to get cycle to Big Integer
            long cycle = getCycle(m);
            String cycleString = String.valueOf(cycle);
            BigInteger cycleBig = new BigInteger(cycleString);

            // Make conversion
            long mod_n = nBig.mod(cycleBig).longValue();

            System.out.println(getFibonacciModHuge(mod_n, m));
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
