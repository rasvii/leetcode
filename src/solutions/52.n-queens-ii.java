package solutions;

/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
import java.util.*;

class Solution {
    private Set<Integer> columns = new HashSet<>();
    private Set<Integer> diagonals = new HashSet<>();
    private Set<Integer> antiDiagonals = new HashSet<>();
    int result = 0;

    private void backtrack(int row, int column, int N) {

        // board found
        if (row == N) {
            result += 1;
        }

        for (int col = 0; col < N; col++) {
            int diag = (row - col) + N;
            int antiDiag = row + col;

            if (columns.contains(col) || diagonals.contains(diag) || antiDiagonals.contains(antiDiag)) {
                continue;
            }

            // add where required
            // board[row][col] = 'Q';
            columns.add(col);
            diagonals.add(diag);
            antiDiagonals.add(antiDiag);

            backtrack(row + 1, col, N);

            // undo
            // board[row][col] = '.';
            columns.remove(col);
            diagonals.remove(diag);
            antiDiagonals.remove(antiDiag);

        }

    }

    public int totalNQueens(int n) {
        // List<Integer> result = new ArrayList<>();
        // int result = 0;

        if (n == 1) {
            return n;
        }

        backtrack(0, 0, n);

        return result;
    }
}
// @lc code=end
