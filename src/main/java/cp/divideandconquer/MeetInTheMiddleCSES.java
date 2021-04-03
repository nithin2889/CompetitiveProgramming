package cp.divideandconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetInTheMiddleCSES {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 6, 7};
    int n = arr.length;
    int x = 9; // required sum

    System.out.println(mim(arr, n, x));
  }

  private static int mim(int[] arr, int n, int x) {
    // break them into 2 arrays
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    for (int i = 0; i < n / 2; i++) {
      left.add(arr[i]);
    }

    for (int i = n / 2; i < n; i++) {
      right.add(arr[i]);
    }

    // apply power set on the left half and store all sums in the list
    List<Integer> leftSum = new ArrayList<>();
    int n1 = left.size();
    int n2 = right.size();

    for (int num = 0; num < (1 << n1); num++) {
      int sum = 0;
      for (int i = 0; i < n1; i++) {
        if ((num & (1 << i)) != 0) {
          sum += left.get(i);
        }
      }
      leftSum.add(sum);
    }

    // apply power set on the right half and store all sums in a map
    Map<Integer, Integer> rightSum = new HashMap<>();
    for (int num = 0; num < (1 << n2); num++) {
      int sum = 0;
      for (int i = 0; i < n2; i++) {
        if ((num & (1 << i)) != 0) {
          sum += right.get(i);
        }
      }
      rightSum.merge(sum, 1, Integer::sum);
    }

    int cnt = 0;
    for (Integer ls : leftSum) {
      cnt += rightSum.get(x - ls);
    }
    return cnt;
  }
}
