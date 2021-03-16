package cp.binarysearch;

public class AggressiveCowSPOJ {

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 8, 9};
    int cows = 3;
    System.out.println("The largest minimum distance to place " + cows + " cows is: "
        + aggressiveCows(arr, cows));
  }

  private static int aggressiveCows(int[] arr, int cows) {
    int n = arr.length;
    int low = 1, high = arr[n - 1] - arr[0];

    while (low <= high) {
      int mid = low + (high - low) / 2;

      int prevCow = arr[0];
      int noOfCows = 1;

      for (int i = 1; i < n; i++) {
        if (arr[i] - prevCow >= mid) {
          noOfCows++;
          prevCow = arr[i];
        }
      }

      if (noOfCows >= cows) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return high;
  }
}
