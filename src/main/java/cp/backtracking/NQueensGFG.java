package cp.backtracking;

public class NQueensGFG {

  public static void main(String[] args) {
    int[][] board = {{0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}};

    int n = board.length;
    System.out.println(n + " queens can be placed safely as shown: ");
    solve(0, board);
  }

  private static boolean isSafe(int i, int j, int[][] chessboard) {
    int n = chessboard.length;

    // upper diagonal
    int dupi = i;
    int dupj = j;

    while (i >= 0 && j >= 0) {
      if (chessboard[i][j] == 1) {
        return false;
      }
      i--;
      j--;
    }

    // left diagonal
    i = dupi;
    j = dupj;
    while (j >= 0) {
      if (chessboard[i][j] == 1) {
        return false;
      }
      j--;
    }

    // down diagonal
    i = dupi;
    j = dupj;
    while (i < n && j >= 0) {
      if (chessboard[i][j] == 1) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  private static void solve(int col, int[][] chessboard) {
    int n = chessboard.length;
    if (col == n) {
      printBoard(n, chessboard);
    }

    // for every column we can place a queen at every row.
    for (int row = 0; row < n; row++) {
      if (isSafe(row, col, chessboard)) {
        chessboard[row][col] = 1;
        solve(col + 1, chessboard);
        // while backtracking we revert it back to 0 for the next recursive calls.
        chessboard[row][col] = 0;
      }
    }
  }

  private static void printBoard(int n, int[][] chessboard) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(chessboard[i][j] + " ");
      }
      System.out.println();
    }
  }
}
