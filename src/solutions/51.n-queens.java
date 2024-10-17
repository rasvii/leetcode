package solutions;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
import java.util.*;

class Solution {

    private Set<Integer> columns = new HashSet<>();
    private Set<Integer> diagonals = new HashSet<>();
    private Set<Integer> antiDiagonals = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        if (n == 1) {
            result.add(Arrays.asList("Q"));
            return result;
        }

        char[][] initBoard = new char[n][n];

        for (char[] row : initBoard) {
            Arrays.fill(row, '.');
        }

        backtrack(initBoard, 0, 0, n, result);

        return result;
    }

    private void backtrack(char[][] board, int row, int column, int N, List<List<String>> result) {

        // board found
        if (row == N) {
            result.add(boardToResult(board));
            return;
        }

        for (int col = 0; col < N; col++) {
            int diag = (row - col) + N;
            int antiDiag = row + col;

            if (columns.contains(col) || diagonals.contains(diag) || antiDiagonals.contains(antiDiag)) {
                continue;
            }

            // add where required
            board[row][col] = 'Q';
            columns.add(col);
            diagonals.add(diag);
            antiDiagonals.add(antiDiag);

            backtrack(board, row + 1, col, N, result);

            // undo
            board[row][col] = '.';
            columns.remove(col);
            diagonals.remove(diag);
            antiDiagonals.remove(antiDiag);

        }

    }

    private List<String> boardToResult(char[][] board) {

        List<String> res = new ArrayList<>();

        for (char[] row : board) {
            String rowString = new String(row);
            res.add(rowString);
        }

        return res;
    }
}
// @lc code=end
