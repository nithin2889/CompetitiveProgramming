package cp.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayUsingXOR {

  public static void main(String[] args) {
    int[] arr = {4, 5, 1, 2, 2, 3, 1, 3, 4};
    System.out.println("The longest subarray length is: " + longestSubarray(arr));
  }

  private static int longestSubarray(int[] arr) {
    int xor = 0, len = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      xor = xor ^ arr[i];

      if (xor == 0) {
        len = i + 1;
      } else if (map.containsKey(arr[i])) {
        len = Math.max(len, i - map.get(xor));
      } else {
        map.put(arr[i], i);
      }
    }
    return len;
  }
}
