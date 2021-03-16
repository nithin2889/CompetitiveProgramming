package cp.binarysearch;

public class SquareRoot {

  public static void main(String[] args) {
    int num = 26;
    System.out.println("Square root of " + num + " is: " + sqrtOf(num));
  }

  private static int sqrtOf(int num) {
    int low = 0, high = num;

    while (low <= high) {
      int mid = (low + (high - low) / 2);

      if (mid * mid <= num) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return high;
  }
}
