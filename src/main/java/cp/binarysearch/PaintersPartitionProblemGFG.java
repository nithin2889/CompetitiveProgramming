package cp.binarysearch;

public class PaintersPartitionProblemGFG {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int n = arr.length;
    int k = 3;
    System.out.println("The minimum time to get the job done is: " + partition(arr, n, k));
  }

  private static boolean validPainter(int[] arr, int n, int k, int midAns) {
    int painter = 1;
    int boards = 0;

    for (int i = 0; i < n; i++) {
      boards += arr[i];

      if (boards > midAns) {
        painter++;
        boards = arr[i];
      }

      if (painter > k) {
        return false;
      }
    }
    return true;
  }

  private static int partition(int[] arr, int n, int k) {
    int low = getMax(arr, n);
    int high = getSum(arr, n);
    int res = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (validPainter(arr, n, k, mid)) {
        res = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return res;
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

  // to get the sum of the array
  private static int getSum(int[] arr, int n) {
    int total = 0;
    for (int i = 0; i < n; i++) {
      total += arr[i];
    }
    return total;
  }
}
