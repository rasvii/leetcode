package solutions;
/*
 * @lc app=leetcode id=3234 lang=java
 *
 * [3234] Count the Number of Substrings With Dominant Ones
 */

// @lc code=start
class Solution {
    public int numberOfSubstrings(String s) {

        int result = 0;
        int n = s.length();
        int[] prefix = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0)
                prefix[i] = s.charAt(i) == '1' ? 1 : 0;
            else {
                prefix[i] = prefix[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0, one = 0;

            for (int j = i; j < n; j++) {
                one = prefix[j] - (i == 0 ? 0 : prefix[i - 1]); // count of one
                count = j - i + 1 - one; // count of zero
                if (count * count > one) {
                    j += (count * count) - one - 1;
                }
                if (count * count <= one) {
                    int kl = (int) Math.sqrt(one);
                    result++;
                    if (kl > count) {
                        result += j + (kl - count) >= s.length() ? s.length() - j - 1 : kl - count;
                        j = j + (kl - count);
                    }
                }
            }
        }

        return result;

    }
}
// @lc code=end
