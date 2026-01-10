package solutions;
/*
 * @lc app=leetcode id=1975 lang=java
 *
 * [1975] Maximum Matrix Sum
 */

// @lc code=start
class Solution {
    public long maxMatrixSum(int[][] matrix) {

        long sum = 0;
        int min = Integer.MAX_VALUE;
        int countOfNegativeNums = 0;
        int n = matrix.length;

        for(int i =0;i < n;i++) {
            for(int j =0; j < n;j++) {
                if(matrix[i][j] < 0) {
                    countOfNegativeNums++;
                    sum -= matrix[i][j];
                }
                else {
                    sum += matrix[i][j];
                }

                min = Math.min(min, Math.abs(matrix[i][j]));
            }
        }

        if(countOfNegativeNums % 2 == 0) return sum;

        return sum - (2 * min );
        
    }
}
// @lc code=end

