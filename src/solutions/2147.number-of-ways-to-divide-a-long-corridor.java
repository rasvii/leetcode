package solutions;

/*
 * @lc app=leetcode id=2147 lang=java
 *
 * [2147] Number of Ways to Divide a Long Corridor
 */

// @lc code=start
class Solution {
    public int numberOfWays(String corridor) {

        int totalSeats = 0;

        for (char c : corridor.toCharArray()) {
            if (c == 'S')
                totalSeats++;
        }

        System.out.println(totalSeats);

        if (totalSeats % 2 == 1 || totalSeats == 0)
            return 0;

        int mod = 1_000_000_007;

        long result = 1, n = corridor.length(), seats = 0;

        int i = 0;

        while (i < n) {
            char c = corridor.charAt(i);

            if (c == 'S') {
                seats++;

                if (seats == totalSeats)
                    break;

                if (seats % 2 == 0) {
                    int count = 1;

                    while (i + 1 < n && corridor.charAt(++i) == 'P') {
                        count++;
                    }

                    result = ((result * count) % mod);
                } else {
                    i++;
                }
            } else {
                i++;
            }

        }

        return (int) result;
    }
}
// @lc code=end
