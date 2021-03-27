package cp.recursion;

public class CountOfSubsequenceSumDivisibleByK {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    int sum = 0;
    int k = 2;
    System.out.println("The count of subsequences that are divisible by " + k + " are: "
        + print(arr, 0, sum, k));
  }

  private static int print(int[] arr, int idx, int sum, int k) {
    int n = arr.length;
    if (idx == n) {
      return sum % k == 0 ? 1 : 0;
    }

    // pick
    sum += arr[idx];
    int left = print(arr, idx + 1, sum, k);
    sum += arr[idx];

    // do not pick
    int right = print(arr, idx + 1, sum, k);
    return left + right;
  }
}
