package solutions;
/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start

/* class Solution {

    // Brute force method
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            int tank = 0;
            boolean isRoundTrip = true;

            for (int j = i; j < n + i + 1; j++) {
                tank += gas[j % n] - cost[j % n];

                if (tank < 0) {
                    isRoundTrip = false;
                    break;
                }
            }

            if (isRoundTrip) {
                return i;
            }
        }

        return -1;

    }
} */

class Solution {
    // Optimized
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int index = 0;
        int remainingGas = 0;
        int totalGas = 0;

        for (int i = 0; i < gas.length; i++) {
            remainingGas += gas[i] - cost[i];

            totalGas += gas[i] - cost[i];

            if (remainingGas < 0) {
                remainingGas = 0;
                index = i + 1;
            }
        }

        return totalGas >= 0 ? index : -1;

    }
}

// @lc code=end
