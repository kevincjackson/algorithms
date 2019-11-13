import java.util.*;

public class MakeStressData{

     public static void main(String []args) {

          // Defined in problem specs
          int NUMBERS_SIZE = 10000;
          int MAX_NUMBER = (int) Math.pow(10,9);

          // Make array
          int[] array = new int[NUMBERS_SIZE];
          for (int i = 0; i < NUMBERS_SIZE; i += 1) {
              array[i] = new Random().nextInt(MAX_NUMBER);
          }

          // To string
          System.out.println(NUMBERS_SIZE);
          for (int item : array) {
              System.out.println(item);
          }
     }
}
