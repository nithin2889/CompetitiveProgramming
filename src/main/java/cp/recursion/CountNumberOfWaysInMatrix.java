package cp.recursion;

public class CountNumberOfWaysInMatrix {

  public static void main(String[] args) {

  }

  private static int print(int[][] a, int i, int j, int m, int n) {
    if (i >= m || j >= m || a[i][j] == 0) {
      return 0;
    }

    if (i == m - 1 && j == n - 1) {
      return 1;
    }

    int left = 0, right = 0;
    if (valid(i, j, m, n)) {
      right = print(a, i, j + 1, m, n);
    }

    if (valid(i, j, m, n)) {
      left = print(a, i, j + 1, m, n);
    }
    return left + right;
  }

  private static boolean valid(int i, int j, int m, int n) {
  }
}
