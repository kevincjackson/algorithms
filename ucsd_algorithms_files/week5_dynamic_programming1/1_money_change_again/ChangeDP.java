import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int amount) {
        int[] base = { 0, 1, 2, 1, 1 };
        int[] coins = new int[amount + 1];

        for (int i = 0; i <= amount; i += 1) {
            if (i <= 4)
                coins[i] = base[i];
            else {
                coins[i] = Math.min(
                    Math.min(
                      coins[i - 1] + 1,
                      coins[i - 3] + 1
                    ),
                    coins[i - 4] + 1
                );
            }
        }

        return coins[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}
