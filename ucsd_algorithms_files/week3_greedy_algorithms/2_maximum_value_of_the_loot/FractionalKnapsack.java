import java.util.Scanner;
import java.util.Arrays;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double totalValue = 0;
        int n = values.length;

        // Initialize items.
        Item[] items = new Item[n];
        for (int i = 0; i < n; i += 1) {
            items[i] = new Item(values[i], weights[i]);
        }

        // Sort items
        Arrays.sort(items);

        // Greedy add to totalValue
        for (Item item : items) {

            if (capacity < 0) {
                return -1;
            }
            else if (capacity == 0) {
                break;
            }
            else if (item.weight > capacity) {
                totalValue += capacity * item.valueByWeight;
                capacity = 0;
            }
            // Weight < capacity
            else {
                totalValue += item.weight * item.valueByWeight;
                capacity -= item.weight;
            }
        }

        // Return
        return totalValue;
    }

    public static class Item implements Comparable<Item>{
        int weight;
        double valueByWeight;
        public Item(int value, int weight) {
            this.weight = weight;
            this.valueByWeight = (double) value / (double) weight;
        }
        public int compareTo(Item b) {
            if (this.valueByWeight < b.valueByWeight) {
                return 1;
            }
            else if (this.valueByWeight == b.valueByWeight) {
                return 0;
            }
            else {
                return -1;
            }
        }
        public String toString() {
            return ("Item { weight: " + this.weight + ", valueByWeight : " + this.valueByWeight);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        double result = getOptimalValue(capacity, values, weights);
        String formatted_result = String.format("%.4f", result);
        System.out.println(formatted_result);
    }
}
