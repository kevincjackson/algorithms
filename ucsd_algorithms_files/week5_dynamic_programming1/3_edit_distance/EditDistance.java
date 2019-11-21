import java.util.*;

class EditDistance {
    public static int editDistance(String a, String b) {
        // Make a table
        int[][] matrix = new int[a.length() + 1][b.length() + 1];

        // Fill it out
        for (int ai = 0; ai <= a.length(); ai += 1)  {
            for (int bi = 0; bi <= b.length(); bi += 1) {

                // Start with filled out edges
                if (ai == 0 && bi == 0) {
                    matrix[ai][bi] = 0;
                    continue;
                }
                if (ai == 0) {
                    matrix[ai][bi] = matrix[ai][bi - 1] + 1;
                    continue;
                }
                if (bi == 0) {
                    matrix[ai][bi] = matrix[ai -1][bi] + 1;
                    continue;
                }

                // Now we'll fill out the real meat of the table
                // If match return upper-left
                if (a.charAt(ai - 1) == b.charAt(bi - 1)) {
                    matrix[ai][bi] = matrix[ai - 1][bi - 1];
                }

                // If mismatch take the min3 of the left, upper-left, and upper + 1
                else {
                    int left = matrix[ai][bi - 1] + 1;
                    int upperLeft = matrix[ai - 1][bi - 1] + 1;
                    int upper = matrix[ai - 1][bi] + 1;
                    matrix[ai][bi] = min3(left, upperLeft, upper);
                }
            }
        }

        // Debug
        // printMatrix(matrix);

        // Answer is the bottom right
        return matrix[a.length()][b.length()];
    }

    private static void printMatrix(int[][] m) {
        for (int col = 0; col < m.length; col += 1) {
            for (int row = 0; row < m[0].length; row += 1) {
                System.out.print(m[col][row]);
            }
            System.out.println();
        }
    }

    // Take the minimum of 3 ints
    private static int min3(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    public static void main(String args[]) {

        boolean TESTING = false;

        if (TESTING) {
            System.out.println("ab,ab: " + (editDistance("ab", "ab") == 0 ? "Pass" : "Fail"));
            System.out.println("short,ports: " + (editDistance("short", "ports") == 3 ? "Pass" : "Fail"));
            System.out.println("editing, distance: " + (editDistance("editing", "distance") == 5 ? "Pass" : "Fail"));
            System.out.println("cart, march: " + (editDistance("cart", "march") == 3 ? "Pass" : "Fail"));
        }

        else {
            // Get input
            Scanner scan = new Scanner(System.in);
            String s = scan.next();
            String t = scan.next();

            // Output
            System.out.println(editDistance(s, t));
        }
    }
}
