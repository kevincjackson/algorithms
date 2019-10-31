import java.util.Scanner;

public class Fibonacci {

    private static boolean TESTING = false;

    private static long calc_fib(int n) {

        int[] fibs = new int[n];

        if (n <= 1) {
            return n;
        }
        else {
            fibs[0] = 0;
            fibs[1] = 1;
            for (int i = 2; i < n; i += 1) {
                fibs[i] = fibs[i-1] + fibs[i-2];
            }
        }

        return fibs[n-1] + fibs[n-2];
    }

    public static void main(String args[]) {
      if (TESTING) {
        assertEquals("10", calc_fib(10), 55);
        assertEquals("30", calc_fib(30), 832040);
        assertEquals("45", calc_fib(45), 1134903170);
      }
      else  {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(calc_fib(n));
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
