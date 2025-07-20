package solutions;
/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> result = new HashMap<>();

        for (String word : strs) {

            char[] ca = new char[26];

            for (char c : word.toCharArray()) {
                ca[c - 'a']++;
            }

            String key = String.valueOf(ca);

            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }

            result.get(key).add(word);

        }

        return new ArrayList<>(result.values());

    }
}
// @lc code=end
