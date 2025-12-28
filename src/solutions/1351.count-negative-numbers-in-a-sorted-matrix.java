package solutions;

class Solution {
    public int countNegatives(int[][] grid) {

        int m = grid.length, n = grid[0].length - 1;

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = n; j >= 0; j--) {
                if (grid[i][j] >= 0)
                    break;

                result++;
            }
        }

        return result;

    }
}