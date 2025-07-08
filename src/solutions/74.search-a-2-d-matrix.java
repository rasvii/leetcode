package solutions;
/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    // Solved this my myself!!! So proud. 09/07/2025
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = (m * n) - 1;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            int midNum = matrix[mid / m][mid % m];

            if (midNum == target) {
                return true;
            }
            if (target < midNum) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        return matrix[low / m][low % m] == target ? true : false;
    }
}
// @lc code=end
