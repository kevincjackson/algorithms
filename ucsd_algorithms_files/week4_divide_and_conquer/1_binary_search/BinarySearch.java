import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int target) {

        int left = 0;
        int right = a.length - 1;
        int mid;

        // Keep shrinking subarray until left and right cross.
        while (left <= right) {
            // Calculate new middle
            mid = (left + right) / 2;

            // We're looking for a lower number, so throw out the right numbers.
            if (target < a[mid] ) {
                right = mid - 1;
            }
            // We're looking for a higher number, so throw out the lower numbers.
            else if (target > a[mid]) {
                left = mid + 1;
            }
            // We found it! We're outta here.
            else if (target == a[mid]) {
                return mid;
            }
            // Unkown logic error.
            else {
                return -2;
            }
        }

        // Couldn't find it.
        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
          targets[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(numbers, targets[i]));
            System.out.print((i != m - 1 ? " " : "\n"));
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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
