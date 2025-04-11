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

            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String sortedWord = new String(letters);

            if (!result.containsKey(sortedWord)) {
                result.put(sortedWord, new ArrayList<>());
            }

            result.get(sortedWord).add(word);

        }

        return new ArrayList<>(result.values());

    }
}
// @lc code=end
