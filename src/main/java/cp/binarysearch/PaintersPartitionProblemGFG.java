package cp.binarysearch;

public class PaintersPartitionProblemGFG {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int n = arr.length;
    int k = 3;
    System.out.println("The minimum time to get the job done is: " + partition(arr, n, k));
  }

  private static int numberOfPainters(int[] arr, int n, int maxLen) {
    int total = 0;
    int numPainters = 1;

    for (int i = 0; i < n; i++) {
      total += arr[i];

      if (total > maxLen) {
        total = arr[i];
        numPainters++;
      }
    }
    return numPainters;
  }

  private static int partition(int[] arr, int n, int k) {
    int low = getMax(arr, n);
    int high = getSum(arr, n);

    while (low < high) {
      int mid = low + (high - low) / 2;
      int requiredPainters = numberOfPainters(arr, n, mid);

      if (requiredPainters <= k) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  // to get the maximum element in the array
  private static int getMax(int[] arr, int n) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  private static int getSum(int[] arr, int n) {
    int total = 0;
    for (int i = 0; i < n; i++) {
      total += arr[i];
    }
    return total;
  }
}
