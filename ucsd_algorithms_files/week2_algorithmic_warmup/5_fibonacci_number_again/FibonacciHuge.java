import java.util.*;

public class FibonacciHuge {

    private static boolean TESTING = true;

    private static long getFibonacciMod(long n, int m) {
        long cycle = getCycle(n, m);
        long mod_n = n % cycle;
        return getFibModHelper(mod_n, m);
    }

    public static long getFibModHelper(long n, int m) {
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
    public static long getCycle(long n, int m) {
        long temp = 0;
        long previous = 0;
        long current = 1;
        long cycle = 0;
        long i = 1;

        //while (i < n) {
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

       // System.out.println("n: " + n + ", m: " + m + ", cycle: " + cycle);
        return cycle;
    }

    public static void main(String[] args) {
        if (TESTING) {
            assertEquals("1 mod2", getFibonacciMod(1, 2), 1);
            assertEquals("2 mod2", getFibonacciMod(2, 2), 1);
            assertEquals("3 mod2", getFibonacciMod(3, 2), 0);
            assertEquals("4 mod2", getFibonacciMod(4, 2), 1);
            assertEquals("5 mod2", getFibonacciMod(5, 2), 1);
            assertEquals("6 mod2", getFibonacciMod(6, 2), 0);
            assertEquals("10 mod2", getFibonacciMod(10, 2), 1);
            assertEquals("239", getFibonacciMod(239, 1000), 161);
            //assertEquals("2,816,213,588", getFibonacciMod(2816213588, 239), 151);
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
