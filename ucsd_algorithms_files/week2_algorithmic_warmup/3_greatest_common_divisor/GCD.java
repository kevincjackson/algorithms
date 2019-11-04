import java.util.*;

// Compute the Greatest Common Divisor
// Exampe: the GCD of 8 and 16 is 2.
// Exampe: the GCD of 8 and 10 is 2.
// Exampe: the GCD of 4 and 5 is 1.
// Input: 1 < a,b < 10^9
// Euclidean Algorithm
//   figures out you can divide repeatedly dive a/b where a is
//   is the remainder, and b becomes the new remainder.
//   When the remainder is 0, the
public class GCD {
  private static int gcd(int a, int b) {

    // Initialize numerator and remainder
    int num = Math.max(a,b);
    int rem = Math.min(a,b);
    int temp_new_rem;

    // Euclidean algorithm
    while (rem != 0) {
        temp_new_rem = num % rem;
        num = rem;
        rem = temp_new_rem;
    }

    return num;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
