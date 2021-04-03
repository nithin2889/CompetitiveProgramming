package cp.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetInTheMiddle {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 6, 7};
    int n = arr.length;
    int x = 9; // required sum

    System.out.println(mim(arr, n, x));
  }

  private static List<Integer> fLeft(int idx, int sum, List<Integer> left) {
    List<Integer> leftSum = new ArrayList<>();
    if (idx == left.size()) {
      leftSum.add(sum);
    }

    // pick
    sum += left.get(idx);
    fLeft(idx + 1, sum, left);
    sum -= left.get(idx);

    // not pick
    fLeft(idx + 1, sum, left);

    return leftSum;
  }

  private static Map<Integer, Integer> fRight(int idx, int sum, List<Integer> right) {
    Map<Integer, Integer> rightSum = new HashMap<>();
    if (idx == right.size()) {
      rightSum.merge(sum, 1, Integer::sum);
    }

    // pick
    sum += right.get(idx);
    fRight(idx + 1, sum, right);
    sum -= right.get(idx);

    // not pick
    fRight(idx + 1, sum, right);

    return rightSum;
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

    List<Integer> leftList = fLeft(0, 0, left);
    Map<Integer, Integer> rightMap = fRight(0, 0, right);

    int cnt = 0;
    for (Integer ls : leftList) {
      cnt += rightMap.get(x - ls);
    }
    return cnt;
  }
}
