package cp.backtracking;

public class RatInAMazeGFG {

  private static StringBuilder movements = new StringBuilder();

  public static void main(String[] args) {
    int a[][] = {{1, 0, 0, 0, 0},
        {1, 1, 1, 1, 1},
        {1, 1, 1, 0, 1},
        {0, 0, 0, 0, 1},
        {0, 0, 0, 0, 1}};

    int n = a.length;
    boolean[][] vis = new boolean[5][5];
    System.out.println(ratRace(0, 0, 5, n, vis, a).toString());
  }

  private static boolean isValidPath(int i, int j, int m, int n, boolean[][] vis, int arr[][]) {
    if (i < 0 || i >= m || j < 0 || j <= n || vis[i][j] || arr[i][j] == 0) {
      return false;
    }
    return true;
  }

  private static StringBuilder ratRace(int i, int j, int m, int n, boolean[][] vis, int[][] arr) {
    // base case
    if (i == m - 1 && j == n - 1) {
      return movements;
    }

    vis[i][j] = true;

    // up
    if (isValidPath(i, j, m, n, vis, arr)) {
      movements.append("U");
      ratRace(i - 1, j, m, n, vis, arr);
      movements.delete(0, movements.length() - 1);
    }

    // down
    if (isValidPath(i, j, m, n, vis, arr)) {
      movements.append("D");
      ratRace(i + 1, j, m, n, vis, arr);
      movements.delete(0, movements.length() - 1);
    }

    // left
    if (isValidPath(i, j, m, n, vis, arr)) {
      movements.append("L");
      ratRace(i, j - 1, m, n, vis, arr);
      movements.delete(0, movements.length() - 1);
    }

    // right
    if (isValidPath(i, j, m, n, vis, arr)) {
      movements.append("R");
      ratRace(i, j + 1, m, n, vis, arr);
      movements.delete(0, movements.length() - 1);
    }
    vis[i][j] = false;

    return movements;
  }
}
