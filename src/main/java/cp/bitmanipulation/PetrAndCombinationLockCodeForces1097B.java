package cp.bitmanipulation;

public class PetrAndCombinationLockCodeForces1097B {

  public static void main(String[] args) {
    int[] arr = {10, 20, 30};
    int n = 3;
    System.out.println("Does the lock for this combination open up? " + lockCombination(arr, n));
  }

  private static String lockCombination(int[] arr, int n) {
    int flag = 0;
    for (int num = 0; num < (1 << n); num++) {
      int sum = 0;
      for (int bits = 0; bits <= n - 1; bits++) {
        if ((num & (1 << bits)) != 0) {
          sum += arr[bits];
        } else {
          sum -= arr[bits];
        }
      }
      if (sum % 360 == 0) {
        flag = 1;
        break;
      }
    }
    return flag == 1 ? "YES" : "NO";
  }
}
