import java.util.*;
import java.io.*;

// Greedy problem practice
// Greedy make a greedy / optimal choice, which reduces problem, repeat
public class CarFueling {

    static int IMPOSSIBLE = -1;
    static int UNKOWN_ERROR = -2;

    static int computeMinRefills(int dist, int tank, int[] stops) {

        // Initialize locations, refills, nextIndex, currentIndex
        // For locations just add 0 to the beginning and the destination at the end
        int[] locations = new int[stops.length + 2];
        locations[0] = 0;
        for (int i = 0; i < stops.length; i += 1) {
            locations[i + 1] = stops[i];
        }
        locations[stops.length + 1] = dist;
        int refills = 0;
        int currentIndex = 0;
        int nextIndex = 0;
        int destinationIndex = locations.length - 1;

        // While your not at final location, keep repeating
        while (currentIndex < destinationIndex) {
            // Greedy choice: get farthest possible stop and refill there if needed
            // Find farthest possible stop
            for (int i = currentIndex + 1; i < destinationIndex + 1; i += 1) {

                  int distanceToStop = locations[i] - locations[currentIndex];

                  // Went too far go back to last location
                  if (distanceToStop > tank) {
                      nextIndex = i - 1;
                      break;
                  }
                  // Keep updating next location
                  else {
                      nextIndex = i;
                  }
            }

            // Reduce problem
            // Guard: no station -> fail
            if (nextIndex == currentIndex) {
                return IMPOSSIBLE;
            }
            // Guard: if you're there, don't refill, just update location
            else if (nextIndex == destinationIndex) {
                currentIndex = destinationIndex;
            }
            // Refill at new station
            else if (nextIndex < destinationIndex) {
                currentIndex = nextIndex;
                refills += 1;
            }
            // Else unkown logic error
            else {
                return UNKOWN_ERROR;
            }
        }

        // Return refills
        return refills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
