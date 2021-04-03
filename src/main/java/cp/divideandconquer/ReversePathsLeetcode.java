package cp.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class ReversePathsLeetcode {

  public static void main(String[] args) {
    int[] arr = {6, 8, 10, 12, 2, 2, 3, 3, 5};
    int n = arr.length;

    System.out.println("Reverse pairs count is: " + solve(0, n - 1, arr));
  }

  private static int solve(int low, int high, int[] arr) {
    if (low == high) {
      return 0;
    }
    int mid = (low + high) / 2;

    int left = solve(low, mid, arr);
    int right = solve(mid + 1, high, arr);

    return merge(low, mid, high, arr) + left + right;
  }

  private static int merge(int low, int mid, int high, int[] arr) {
    int left = 0;
    int right = mid + 1;
    int count = 0;

    List<Integer> temp = new ArrayList<>();

    for (int i = low; i <= mid; i++) {
      // only executes for N times in its entirety or in one instance.
      while (arr[low] > 2 * arr[right] && right < high) {
        low++;
        right++;
      }
      // once the right stops moving we get the count.
      count += (right - (mid + 1));
    }

    while (left <= mid) {
      temp.add(arr[left]);
      left++;
    }

    while (right <= high) {
      temp.add(arr[right]);
      right++;
    }
    return count;
  }
}
