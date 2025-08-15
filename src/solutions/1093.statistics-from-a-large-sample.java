package solutions;
/*
 * @lc app=leetcode id=1093 lang=java
 *
 * [1093] Statistics from a Large Sample
 */

// @lc code=start
class Solution {
    public double[] sampleStats(int[] count) {

        int min = Integer.MAX_VALUE, max = 0;
        double mean, median = 0, mode = 0;
        double sum = 0;
        int counter = 0;
        int freq = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                counter += count[i];
                sum = sum + ((long) count[i] * i);

                if (count[i] > freq) {
                    freq = count[i];
                    mode = i;
                }
            }
        }

        if (counter % 2 == 0) {
            int sumCount = 0;
            int mid1 = counter / 2;
            int mid2 = mid1 + 1;
            boolean firstFound = false;

            for (int i = 0; i < count.length; i++) {
                sumCount += count[i];
                if (!firstFound && sumCount >= mid1) {
                    firstFound = true;
                    median = i;
                }

                if (sumCount >= mid2) {
                    median += i;
                    break;
                }
            }

            median = median / 2;
        } else {
            int sumCount = 0;
            int mid = counter / 2 + 1;

            for (int i = 0; i < count.length; i++) {
                sumCount += count[i];
                if (sumCount >= mid) {
                    median = i;
                    break;
                }
            }
        }

        double[] result = { min, max, sum / counter, median, mode };

        return result;
    }
}
// @lc code=end
