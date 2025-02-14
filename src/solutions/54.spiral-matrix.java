package solutions;
/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);

        if (matrix.length == 0)
            return result;

        int rowStart = 0, rowEnd = matrix.length - 1;
        int columnStart = 0, columnEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && columnStart <= columnEnd) {

            // Traverse right
            for (int j = columnStart; j <= columnEnd; j++) {
                result.add(matrix[rowStart][j]);
            }
            rowStart++;

            // Traverse down
            for (int j = rowStart; j <= rowEnd; j++) {
                result.add(matrix[j][columnEnd]);
            }
            columnEnd--;

            if (rowStart <= rowEnd) {
                // Traverse left
                for (int j = columnEnd; j >= columnStart; j--) {
                    result.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }

            if (columnStart <= columnEnd) {
                // Traverse up
                for (int j = rowEnd; j >= rowStart; j--) {
                    result.add(matrix[j][columnStart]);
                }
            }

            columnStart++;
        }

        return result;
    }
}
// @lc code=end
