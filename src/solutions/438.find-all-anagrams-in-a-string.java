package solutions;
/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int[] map = new int[126];

        for (char c : p.toCharArray()) {
            map[c]++;
        }

        int counter = p.length(), left = 0, right = 0;

        while (right < s.length()) {

            char rightC = s.charAt(right);
            if (map[rightC] > 0) {
                counter--;
            }

            map[rightC]--;

            while (counter == 0) {
                char leftC = s.charAt(left);
                map[leftC]++;

                if (right - left + 1 == p.length()) {
                    result.add(left);
                }

                if (map[leftC] > 0) {
                    counter++;
                }
                left++;
            }

            right++;
        }

        return result;
    }
}
// @lc code=end
