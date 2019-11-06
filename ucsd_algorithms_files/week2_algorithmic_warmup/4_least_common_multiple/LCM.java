import java.util.*;

// Least Common Multiple
// Euclid's Algotithm
//  1. GCD(a, b)
//  2. Divide either of the numbers by the GCD.
//  3. Multiply the other number by that.
// Examples
//  lcm(6, 8) -> 24
//  lcm(761457, 614573 -> 467970912861
// Input: 1 <= a, b <= 10^7
//   Yields 10^14
public class LCM {
    private static long lcm(int a, int b) {
        if (a < 1 || b < 1) {
            return 0;
        }
        else {
            int gcd = gcd(a,b);
            int divided = a / gcd;
            long multiplied = (long) b * (long) divided;

            return multiplied;
        }
    }

  // Implementation of Fast / Euclid's Algorithm for Greatest Common Divisor
  private static int gcd(int a, int b) {
      if (a < 1 || b < 1) {
          return 0;
      }
      else {
          int num = Math.max(a,b);
          int rem = Math.min(a,b);
          int temp_new_rem = 1;

          while (temp_new_rem != 0) {
              temp_new_rem = num % rem;
              num = rem;
              rem = temp_new_rem;
          }

          return num;
      }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
