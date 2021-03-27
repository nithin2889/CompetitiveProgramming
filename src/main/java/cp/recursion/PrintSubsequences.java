package cp.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequences {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    List<Integer> ls = new ArrayList<>();
    print(arr, 0, ls);
  }

  private static void print(int[] arr, int idx, List<Integer> ls) {
    int n = arr.length;
    if (idx == n) {
      for (Integer l : ls) {
        System.out.print(l + " ");
      }
      return;
    }

    // pick
    // insert to the data structure
    ls.add(arr[idx]);
    print(arr, idx + 1, ls);
    // make sure to delete the last element because while you come back you need to remove.
    ls.remove(ls.size() - 1);

    // not pick
    print(arr, idx + 1, ls);
  }
}
