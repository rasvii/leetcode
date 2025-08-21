package solutions;
/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, int row, int col, int charIdx, String word) {
        if (charIdx == word.length())
            return true;
        if (row < 0 || row == board.length || col < 0 || col == board[0].length)
            return false;
        if (board[row][col] != word.charAt(charIdx))
            return false;

        char orignal = board[row][col];
        if (orignal == '.')
            return false;
        board[row][col] = '.';
        charIdx++;
        boolean exists = backtrack(board, row + 1, col, charIdx, word) ||
                backtrack(board, row - 1, col, charIdx, word) ||
                backtrack(board, row, col + 1, charIdx, word) ||
                backtrack(board, row, col - 1, charIdx, word);

        board[row][col] = orignal;

        return exists;
    }
}
// @lc code=end
