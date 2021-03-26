package cp.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequencesUsingPowerSet {

  public static void main(String[] args) {
    int[] arr = {6, 8, 11};
    int n = 3;
    System.out.println("The subsequences are: ");
    printAllSubsequences(arr, n);
  }

  private static void printAllSubsequences(int[] arr, int n) {
    for (int num = 0; num < (1 << n); num++) {
      List<Integer> ll = new ArrayList<>();

      for (int bit = 0; bit <= n - 1; bit++) {
        if ((num & (1 << bit)) != 0) {
          ll.add(arr[bit]);
        }
      }

      for (Integer l : ll) {
        System.out.print("{" + l + "}");
      }
    }
  }
}
