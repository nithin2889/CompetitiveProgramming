package cp.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequences {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    List<Integer> ls = new ArrayList<>();

    // using "pick not-pick" method.
    print(arr, 0, ls);

    // using "starting from current index, picking till the end" method.
    printOtherTechnique(arr, 0, ls);
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

  private static void printOtherTechnique(int[] arr, int idx, List<Integer> ls) {
    int n = arr.length;
    for (Integer l : ls) {
      System.out.println(l + " ");
    }

    for (int i = idx; i < n; i++) {
      ls.add(arr[i]);
      printOtherTechnique(arr, idx + 1, ls);
      ls.remove(ls.size() - 1);
    }
  }
}
