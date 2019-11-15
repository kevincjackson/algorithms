import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    // -> { m1, m2 } where m1 is the left most index where its value equals the pivotValue
    //                     m2 is the right most index where its value equals the pivotValue
    private static int[] partition3(int[] arr, int left, int right) {

        // Initializations
        int pivotValue = arr[left];
        int m1 = left;
        int m2 = left;
        int lessers = left;

        // Scan the remaining elements
        for (int current = left + 1; current <= right; current += 1) {

            // Found lessersPivot:
            if (arr[current] < pivotValue) {
                  // advance lessers pointer
                  lessers += 1;

                  // Swap with current
                  int temp = arr[current];
                  arr[current] = arr[lessers];
                  arr[lessers] = temp;
            }

            // Found equalToPivot: advance m2 (equal region), swap with current
            if (arr[current] == pivotValue) {
                  // advance pointers
                  m2 += 1;
                  lessers += 1;

                  // insert the pivot at the beginning
                  arrayInsertByIndexes(arr, current, left + 1);
            }
        }

        // Move pivots to their final spots
        for (int i = m2 + 1, offset = 0; i <= lessers; i += 1) {
            arrayInsertByIndexes(arr, i, m1 + offset);
            offset += 1;
        }

        // Update pivot pointers
        int pivotOffset = lessers - m2;
        m1 += pivotOffset;
        m2 += pivotOffset;

        // Outta here.
        int[] m = { m1, m2 };
        return m;
    }

    private static void quicksort3(int[] array, int left, int right) {

        // Nothing to do
        if (left >= right) {
            return;
        }

        // Pick random pivot that's not the farthest left
        int pivot = random.nextInt(right - left + 1) + left; // Random pivot

        // Swap left and pivot
        int tempLeft = array[left];
        array[left] = array[pivot];
        array[pivot] = tempLeft;

        // use partition3
        // partition3 establishes a middle subarray where its values equal the subarray
        int[] mids = partition3(array, left, right);
        quicksort3(array, left, mids[0] - 1);
        quicksort3(array, mids[1] + 1, right);
    }


    // With a single scan, move the initial element to it's final spot,
    // and have every item before it be less than or equal,
    // and every tem after it be greater then it.
    //
    // Partition
    // The pivot is the left spot
    // The lessers is in the left spot
    // Scan from left + 1 to the end.
    // As we find lessers advance lessers and swap with current
    // This automagically moves the greaterThan to the right
    // After the scan, swap the pivot with the less than.
    private static int partition2(int[] a, int l, int r) {
        int pivotValue = a[l];
        int lesserIndex = l;
        for (int currentIndex = l + 1; currentIndex <= r; currentIndex++) {

            // Expand region of less than
            if (a[currentIndex] <= pivotValue) {
                lesserIndex++;

                // Swap the pivot and the less than value
                int temp = a[currentIndex];
                a[currentIndex] = a[lesserIndex];
                a[lesserIndex] = temp;
            }
        }

        // Swap the pivot when your done.
        int temp = a[l];
        a[l] = a[lesserIndex];
        a[lesserIndex] = temp;
        return lesserIndex;
    }

    private static int medianPivotIndex(int[] arr, int left, int right) {

        // Optimization
        int mid = (left + right) / 2;

        // Make tuples
        int[] lt = { left, arr[left], 0 };
        int[] md = { mid, arr[mid], 0 };
        int[] rt = { right, arr[right], 0 };

        // Get extremes
        int max = Math.max(Math.max(arr[left], arr[mid]), arr[right]);
        int min = Math.min(Math.min(arr[left], arr[mid]), arr[right]);

        // Set extremes
        if (lt[1] == max || lt[1] == min)
            lt[2] = 1;
        if (rt[1] == max || rt[1] == min)
            rt[2] = 1;

        // Return the median
        if (lt[2] == 0) {
            return left;
        }
        else if (rt[2] == 0) {
            return right;
        }
        else {
            return mid;
        }
    }

    private static void randomizedQuickSort(int[] array, int left, int right) {

        // Nothing to do
        if (left >= right) {
            return;
        }

        // Pick random pivot that's not the farthest left
        int randomPivot = random.nextInt(right - left + 1) + left;

        // Swap left and randomPivot
        int tempLeft = array[left];
        array[left] = array[randomPivot];
        array[randomPivot] = tempLeft;

        //use partition3
        int mid = partition2(array, left, right);
        randomizedQuickSort(array, left, mid - 1);
        randomizedQuickSort(array, mid + 1, right);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        quicksort3(a, 0, n - 1);
        printArray(a);
    }

    // Helper function to move elements inside an array
    // Example: int[] arr = { 11, 22, 33, 44, 55 }
    //          arrayInsertByIndexes(arr, 4, 0) -> { 55, 11, 22, 33, 44 }
    private static void arrayInsertByIndexes(int[] arr, int source, int dest) {

        // Nothing to do
        if (dest == source) {
            return;
        }

        // Optimization
        int temp;

        // Insert forwards we'll just swap
        if (dest > source) {
            temp = arr[source];
            arr[source] = arr[dest];
            arr[dest] = temp;

            return;
        }

        // Initialize pointers
        int a = source;
        int b = a - 1;

        // Keep swapping back until you hit the destination
        while (b >= dest) {

            // Swap values
            temp = arr[b];
            arr[b] = arr[a];
            arr[a] = temp;

            // Settup next pair
            a -= 1;
            b -= 1;
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i += 1) {
            System.out.print(array[i]);
            System.out.print(i != array.length - 1 ? " " : "\n");
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
