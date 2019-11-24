import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] arr) {

        // Check is total is divisible by 3
        int total = 0;
        for (int i : arr)
            total += i;
        if ((total % 3) != 0) {
            return 0;
        }

        // Good to go, initialize data
        int target = total / 3;
        Arrays.sort(arr);
        ArrayList<Integer> pool = new ArrayList<Integer>();
        for (int i : arr)
            pool.add(i);
        ArrayList<Integer> rejects = new ArrayList<Integer>();
        ArrayList<Integer> lotA = new ArrayList<Integer>();
        ArrayList<Integer> lotB = new ArrayList<Integer>();
        ArrayList<Integer> lotC = new ArrayList<Integer>();

        // Cool lets work on lotA
        lotA.add(pool.remove(pool.size() - 1));
        while (sumOf(lotA) != target) {

            // Guard against empty pool
            if (pool.isEmpty())
                return 0;

            // Check if the lotTotal is too high
            int lotTotal = sumOf(lotA);
            if (lotTotal > target) {
                // remove last, add to rejects
                rejects.add(lotA.remove(lotA.size() - 1));
            }

            // Sum is too low
            else {
                // Look for needed amount
                Integer needed = target - sumOf(lotA);
                if (pool.contains(needed)) {
                    lotA.add(pool.remove(pool.indexOf(needed)));

                    // Rebuild pool
                    while (rejects.size() > 0)
                        pool.add(rejects.remove(rejects.size() -1));
                }
                else {
                    // Keep trying with next pool member
                    lotA.add(pool.remove(pool.size() - 1));
                }
            }
        }

        // Nice lets work on lotB
        lotB.add(pool.remove(pool.size() - 1));
        while (sumOf(lotB) != target) {

            // Guard against empty pool
            if (pool.isEmpty())
                return 0;

            // Check if the lotTotal is too high
            int lotTotal = sumOf(lotB);
            if (lotTotal > target) {
                // remove last, add to rejects
                rejects.add(lotB.remove(lotB.size() - 1));
            }

            // Sum is too low
            else {
                // Look for needed amount
                Integer needed = target - sumOf(lotB);
                if (pool.contains(needed)) {
                    lotB.add(pool.remove(pool.indexOf(needed)));

                    // Rebuild pool
                    while (rejects.size() > 0)
                        pool.add(rejects.remove(rejects.size() -1));
                }
                else {
                    // Keep trying with next pool member
                    lotB.add(pool.remove(pool.size() - 1));
                }
            }
        }

        // Debug
        /*
        System.out.println("pool: " + Arrays.toString(pool.toArray()));
        System.out.println("rejects: " + Arrays.toString(rejects.toArray()));
        System.out.println("lotA: " + Arrays.toString(lotA.toArray()));
        System.out.println("lotB: " + Arrays.toString(lotB.toArray()));
        */

        // Nice almost there, check the remaining numbers
        if (sumOf(pool) == target) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private static Integer sumOf(ArrayList<Integer> arr) {
        Integer sum = 0;
        for (Integer i : arr)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}
