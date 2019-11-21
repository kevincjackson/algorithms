import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] items) {

        // Dynamic bottom up solution
        // Make a table for W + 1 and items + 1
        int[][] tab = new int[items.length + 1][W + 1];

        // Fill out table
        for (int col = 0; col <= items.length; col += 1) {
            for (int row = 0; row <= W; row += 1) {

                // Initialize first row
                if (row == 0) {
                    tab[col][row] = 0;
                }

                // Initialize first col
                else if (col == 0) {
                    tab[col][row] = 0;
                }

                // The real work
                else {
                    // Fill out max of item above, or item above and left
                    int above = tab[col - 1][row];
                    int item  = items[col - 1];

                    // Check if there's room for the item.
                    if (item <= row) {
                        int aboveLeft = tab[col - 1][row - item] + item;
                        tab[col][row] = Math.max(above, aboveLeft);
                    }
                    // If not you have to use what's above.
                    else {
                        tab[col][row] = above;
                    }
                }
            }
        }

        return tab[items.length][W];
    }

    public static void main(String[] args) {

        // Change below to test!
        boolean TESTING = false;

        if (TESTING) {
            int result = optimalWeight(10, new int[] { 1, 4, 8 });
            if (result == 9) {
                System.out.println("Pass");
            }
            else {
                System.out.println("Expected 9: got " + result);
            }
            return;
        }

        // Get input
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }

        // Output
        System.out.println(optimalWeight(W, w));
    }
}
