package solutions;
/*
 * @lc app=leetcode id=1093 lang=java
 *
 * [1093] Statistics from a Large Sample
 */

// @lc code=start
class Solution {
    public double[] sampleStats(int[] count) {

        double min = Integer.MAX_VALUE, max = -1;
        double total = 0;
        int counter = 0;
        double[] mode = { 0, 0 };

        for (int i = 0; i < count.length; i++) {

            if (count[i] != 0) {
                if (min == Integer.MAX_VALUE)
                    min = i;
                max = i;
                counter += count[i];

                total += (long) i * count[i];

                if (count[i] > mode[1]) {
                    mode[0] = i;
                    mode[1] = count[i];
                }
            }
        }

        double mean = total / counter;

        // median
        double median;
        int mid1 = (counter + 1) / 2; // position of middle (odd) or first middle (even)
        int mid2 = (counter % 2 == 0) ? (counter / 2 + 1) : mid1;

        int running = 0;
        int first = -1, second = -1;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                continue;
            running += count[i];

            if (first == -1 && running >= mid1) {
                first = i;
            }
            if (running >= mid2) {
                second = i;
                break;
            }
        }

        median = (first + second) / 2.0;

        return new double[] { min, max, mean, median, mode[0] };

    }
}
// @lc code=end
