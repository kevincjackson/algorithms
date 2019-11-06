import java.util.Scanner;

public class Change {
    private static int getChange(int m) { //28

        // Initialize two counters:
        //   one for the coins, one for the changing amount
        int amount = m;
        int coins = 0;

        int[] denominations = { 10, 5, 1 };

        // For each coin denomination
        for (int d : denominations) {

            // Add the number of coins
            coins += amount / d;

            // Reduce the amount of the coin
            amount = amount % d;
        }

        return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
