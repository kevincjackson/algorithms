import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    static boolean IS_TESTING = false;

    // Multiply all the numbers times each other and return the biggest one.
    static long getMaxPairwiseProductNaive(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;
        int maybeLarger = 0;

        for (int a = 0; a < n; a += 1) {
            for (int b = a + 1; b < n; b += 1) {
                maybeLarger = numbers[a] * numbers[b];
                if (maybeLarger > max_product) {
                    max_product = maybeLarger;
                }
            }
        }

        return max_product;
    }

    // Scan for the largest two numbers, and multiply those two.
    static long getMaxPairwiseProductScanLargest2(int[] numbers) {

        int n = numbers.length;
        int pointer1;
        int pointer2;

        // Initialize pointers to the first two values
        if (numbers[0] > numbers[1]) {
            pointer1 = 0;
            pointer2 = 1;
        }
        else {
            pointer1 = 1;
            pointer2 = 0;
        }

        // Find the largest two values
        for (int i = 2; i < n; i += 1) {
            if (numbers[i] > numbers[pointer1]) {

                // Old largest slides over to the number two position
                pointer2 = pointer1;
                pointer1 = i;
            }
            else if (numbers[i] > numbers[pointer2]) {
                pointer2 = i;
            }
            else {
              continue;
            }
        }

        return (long) numbers[pointer1] * numbers[pointer2];
    }

    public static void main(String[] args) {
        if (IS_TESTING) {
            manual_test();
            stress_test(5, 100000);
        }
        else {
            FastScanner scanner = new FastScanner(System.in);
            int n = scanner.nextInt();
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }
            System.out.println(getMaxPairwiseProductScanLargest2(numbers));
        }
    }

    public static void manual_test() {
        assertEquals("Basic1", getMaxPairwiseProductScanLargest2(new int[] {1,2,3,4}), 12);
        assertEquals("Basic2", getMaxPairwiseProductScanLargest2(new int[] {4,3,2,1}), 12);
        assertEquals("Overflow", getMaxPairwiseProductScanLargest2(new int[] {10000, 10000}), 100000000);
        assertEquals("Large Data Set", getMaxPairwiseProductScanLargest2(new int[] {10000, 10000}), 100000000);
    }

    public static void stress_test(int maxArraySize, int maxNumber) {

        Random random = new Random();

        for (int t = 0; t < 100; t += 1) {

            int maybeArraySize = random.nextInt(maxArraySize);
            int arraySize = maybeArraySize >= 2 ? maybeArraySize : 2;
            int[] nums = new int[arraySize];

            // Fill array with random numbers
            for (int i = 0; i < arraySize; i += 1) {
                nums[i] = random.nextInt(maxNumber) + 1;
            }

            // Get results from algo1
            long result1 = getMaxPairwiseProductNaive(nums);

            // Get result from algo2
            long result2 = getMaxPairwiseProductScanLargest2(nums);

            // Report results
            if (result1 == result2) {
              System.out.print(".");
            }
            else {
              System.out.println("FAIL: " + result1 + ", " + result2);
            }
        }
        System.out.println();

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

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
