package solutions;
/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> patternMap = new HashMap<>();
        HashSet<String> seenWords = new HashSet<>();

        String[] words = s.split(" ");

        if (pattern.length() != words.length)
            return false;

        for (int index = 0; index < pattern.length(); index++) {

            char c = pattern.charAt(index);
            String word = words[index];

            if (patternMap.containsKey(c)) {
                if (!patternMap.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (seenWords.contains(word)) {
                    return false;
                }

                patternMap.put(c, word);
                seenWords.add(word);
            }
        }

        return true;

    }
}
// @lc code=end
