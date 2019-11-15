public class KJSorts {

    public static void main(String[] args) {
        System.out.println("Yay!");
    }

    // Sorts array in place
    public static void selectionSort(int[] nums) {

        // At each index
        for (int i = 0; i < nums.length - 1; i += 1) {

            // Keep track of the index of the lowest value
            int lowestIndex = i + 1;

            // Scan for a lower value
            for (int j = lowestIndex; j < nums.length; j += 1) {

                // If you find one keep track of the index.
                // We need to swap with it.
                if (nums[j] < nums[lowestIndex])
                    lowestIndex = j;
            }

            // Swap if you need to
            if (nums[lowestIndex] < nums[i])
                swapElements(nums, lowestIndex, i);
        }
    }

    // Helper function
    private static void swapElements(int[] a, int index1, int index2) {
        int temp_index2 = a[index2];
        a[index2] = a[index1];
        a[index1] = temp_index2;
    }
}
