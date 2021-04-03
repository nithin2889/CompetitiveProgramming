package cp.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class InversionsCountSPOJ {

  public static void main(String[] args) {
    int[] arr = {7, 8, 6, 4, 2, 1, 4, 3};
    int n = arr.length;

    System.out.println("Number of inversions are: " + solve(0, n - 1, arr));
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

    while (left <= mid && right <= high) {
      // "<=" becomes very important while counting all inversions.
      if (arr[left] <= arr[right]) {
        temp.add(arr[left]);
        left++;
      } else {
        temp.add(arr[right]);
        count += (mid - left + 1);
        right++;
      }
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
