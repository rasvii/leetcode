package solutions;
/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int low = matrix[0][0], high = matrix[row - 1][col - 1] + 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0, j = col - 1;

            for (int i = 0; i < row; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }

            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;

    }
}
// @lc code=end
