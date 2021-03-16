package cp.binarysearch;

import java.util.Arrays;

public class AmazonMinValueOfK {

  public static void main(String[] args) {
    int[] arr = {2, 5, 10, 13, 6, 2, 10};
    int sum = 10;

    System.out.println("The minimum value of k for the given array is: " + findMinValue(arr, sum));
  }

  private static int findMinValue(int[] arr, int sum) {
    int max = Arrays.stream(arr).max().getAsInt();
    int low = 1, high = max + 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      int sm = 0;

      for (int i = 0; i < arr.length; i++) {
        sm += arr[i] / mid;
      }

      if (sm <= sum) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
