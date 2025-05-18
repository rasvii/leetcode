package solutions;
/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int minLength = Integer.MAX_VALUE, left = 0, right = 0, counter = t.length(), minStart = 0;

        while (right < s.length()) {
            char cRight = s.charAt(right);
            if (map[cRight] > 0)
                counter--;
            map[cRight]--;
            right++;

            while (counter == 0) {
                if (minLength > (right - left)) {
                    minLength = right - left;
                    minStart = left;
                }

                char cLeft = s.charAt(left);
                map[cLeft]++;

                if (map[cLeft] > 0)
                    counter++;
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minLength + minStart);
    }
}
// @lc code=end
