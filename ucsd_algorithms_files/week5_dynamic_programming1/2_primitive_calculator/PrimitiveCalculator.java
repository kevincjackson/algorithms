import java.util.*;

// Calculator can only do three operations
//   Add 1
//   Multiply x 2
//   Multiply x 3
// Note: This algorithm has two loops.
//   1. Find the minimum number of moves.
//   2. Recreate the numbers associated with each move.
//   Another option would be store the move with each number as tuple.
//   This is a trade of between space, and time complexity. Since there's a
//   potential for a large number of possibilites, I opted for the saving space.
public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> optimals = new ArrayList<Integer>();
        int[] count = new int[n + 1];
        int[] base = { 0, 0, 1, 1 };
        int[] possibleOps = new int[3];
        int ILLEGAL = Integer.MAX_VALUE;
        int LOGIC_ERROR = -2;

        // Dynamic programming
        // Keep track of number of moves for each number
        for (int i = 0; i <= n; i += 1) {

            // Setup base cases
            if (i <= 3) {
                count[i] = base[i];
            }

            else {
                // Setup possible operations
                possibleOps[0] = count[i - 1] + 1;
                possibleOps[1] = (i % 2 == 0) ? count[i / 2] + 1 : ILLEGAL;
                possibleOps[2] = (i % 3 == 0) ? count[i / 3] + 1 : ILLEGAL;

                // pick the smallest legal operation
                if (possibleOps[0] <= possibleOps[1] &&
                    possibleOps[0] <= possibleOps[2]) {
                        count[i] = possibleOps[0];
                }
                else if (possibleOps[1] <= possibleOps[0] &&
                    possibleOps[1] <= possibleOps[2]) {
                        count[i] = possibleOps[1];
                }
                else if (possibleOps[2] <= possibleOps[0] &&
                    possibleOps[2] <= possibleOps[1]) {
                        count[i] = possibleOps[2];
                }
                else {
                    count[i] = LOGIC_ERROR;
                }
            }
        }

        // Reconstruct the sequence starting from the end
        // Add the last number
        int move = count[n];
        int lastNumber = n;
        optimals.add(n);

        // Search through rest
        int j = n - 1;
        while (move > 0) {
            // Look for next lower legal number
            if (count[j] < move &&
                (lastNumber - 1 == j ||
                lastNumber / 3 == j ||
                lastNumber / 2 == j)) {
                    optimals.add(j);
                    lastNumber = j;
                    move -= 1;
            }
            j -= 1;
        }

        // Unbackwards list.
        Collections.reverse(optimals);

        return optimals;
    }

    private static List<Integer> naive_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> optimals = optimal_sequence(n);
        System.out.println(optimals.size() - 1);
        for (Integer o: optimals) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i += 1) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}
