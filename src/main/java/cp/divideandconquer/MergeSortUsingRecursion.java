package cp.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class MergeSortUsingRecursion {

  public static void main(String[] args) {
    int[] arr = {5, 1, 3, 2, 7, 1};
    int n = arr.length;

    solve(0, n - 1, arr);

    System.out.println("After divide and conquer: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void merge(int low, int mid, int high, int[] arr) {
    int left = low;
    int right = mid + 1;
    List<Integer> temp = new ArrayList<>();

    while (left <= mid && right <= high) {
      if (arr[left] < arr[right]) {
        temp.add(arr[left]);
        left++;
      } else {
        temp.add(arr[right]);
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

    for (int i = low; i <= high; i++) {
      arr[i] = temp.get(i - low);
    }
  }

  private static void solve(int low, int high, int[] arr) {
    if (low == high) {
      return;
    }

    int mid = (low + high) / 2;

    solve(low, mid, arr);
    solve(mid + 1, high, arr);

    merge(low, mid, high, arr);
  }
}
