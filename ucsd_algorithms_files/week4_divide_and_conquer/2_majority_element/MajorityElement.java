import java.util.*;
import java.io.*;

// Majority element is looking for an element which occurs over half the time
// in an array.
//
// Usually the study algorithms guarantee there is a majority element, but
// this is not guaranteed.
//
// The getMajority function will return two possibilities of integers.
//    -> Positive Integer: the majority element
//    -> -1: no majority element
public class MajorityElement {

    private static int MAJORITY_ELEMENT = 1;
    private static int NO_MAJORITY_ELEMENT = -1;

    private static int getMajorityElementNaive(int[] nums) {

        // For each number
        for (int target : nums) {

            // Count how many times it occurs
            int count = 0;
            for (int current : nums) {
                if (current == target) {
                    count += 1;

                    // If the count is above half, were done
                    if (count > nums.length / 2) {
                        return target;
                    }
                }
            }
        }

        // If you checked everything and didn't find one, report that.
        return NO_MAJORITY_ELEMENT;
    }

    private static int hasMajorityElementUsingSort(int[] nums) {

        // If we sort the array, any majority element would have to sit in the middle
        Arrays.sort(nums);
        int middle = nums[nums.length / 2];

        // Check to see if it is the majority
        int majority_size = nums.length / 2;
        int count = 0;
        for (int n : nums) {
            if (n == middle) {
                count += 1;
                if (count > majority_size) {
                    return MAJORITY_ELEMENT;
                }
            }
        }

        // Couldn't find majority element
        return NO_MAJORITY_ELEMENT;
    }

    // I've tried two ways both use more than a 1024M heap space and won't pass the tests
    private static int hasMajorityElementUsingHashMap(int[] nums) {
        int MAJORITY = 1;
        int NO_MAJORITY = 0;
        int majority_size = nums.length / 2;

        // Make counter
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>(nums.length);

        // Loop and count
        for (int n : nums) {

            // Check for hash key
            // If have it, add to it
            if (counter.containsKey(n)) {
                counter.put(n, counter.get(n) + 1);
            }
            // If not, set to one since you just found it
            else {
                counter.put(n, 1);
            }

            // If you found a majority, you're done
            if (counter.get(n) > majority_size) {
                return MAJORITY;
            }
        }

        // Checked everything, no majority found
        return NO_MAJORITY;
    }

    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int result = hasMajorityElementUsingHashMap(numbers);
        System.out.println(result);
        // if (getMajorityElement(a, 0, a.length) != -1) {
        //     System.out.println(1);
        // } else {
        //     System.out.println(0);
        // }
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
