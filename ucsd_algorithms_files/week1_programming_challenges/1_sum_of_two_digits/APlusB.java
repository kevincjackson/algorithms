import java.util.Scanner;

class APlusB {
    static int sumOfTwoDigits(int first_digit, int second_digit) {
        return first_digit + second_digit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(sumOfTwoDigits(a, b));
    }
}
