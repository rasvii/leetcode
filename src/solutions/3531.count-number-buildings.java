package solutions;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        int[][] xaxis = new int[n + 1][2];
        int[][] yaxis = new int[n + 1][2];

        for (int[] building : buildings) {
            int x = building[0], y = building[1];

            if (xaxis[x][0] == 0)
                xaxis[x][0] = y;
            else
                xaxis[x][0] = Math.min(xaxis[x][0], y);

            if (yaxis[y][0] == 0)
                yaxis[y][0] = x;
            else
                yaxis[y][0] = Math.min(yaxis[y][0], x);

            xaxis[x][1] = Math.max(xaxis[x][1], y);
            yaxis[y][1] = Math.max(yaxis[y][1], x);
        }

        int count = 0;

        for (int[] building : buildings) {
            int x = building[0], y = building[1];

            if (xaxis[x][0] == 0 || xaxis[x][1] == 0 || yaxis[y][0] == 0 || yaxis[y][1] == 0)
                continue;

            if (xaxis[x][0] < y && xaxis[x][1] > y && yaxis[y][0] < x && yaxis[y][1] > x) {
                count++;
            }
        }

        return count;

    }
}
