/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;

                return ba.compareTo(ab);
            }
        };

        Arrays.sort(numsStr, comparator);

        if (numsStr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numsStr.length; i++) {
            sb.append(numsStr[i]);
        }

        return sb.toString();
    }
}
// @lc code=end
