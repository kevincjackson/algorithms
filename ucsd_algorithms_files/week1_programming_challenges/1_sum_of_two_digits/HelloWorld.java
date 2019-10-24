public class HelloWorld {
  public static void main(String[] args) {

    for (int i = 0; i <= 15; i++) {
      System.out.println(fizzbuzz(i));
    }
  }

  static String fizzbuzz(int i) {
    if (i % 15 == 0) {
      return "fizzbuzz";
    }
    else if (i % 3 == 0) {
      return "fizz";
    }
    else if (i % 5 == 0) {
      return "buzz";
    }
    else {
      return Integer.toString(i);
    }
  }
}
