package solutions;
/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

// @lc code=start
import java.util.*;

//Brute force
/* class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> letterCountMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if (!letterCountMap.containsKey(magazine.charAt(i))) {
                letterCountMap.put(magazine.charAt(i), 1);
            } else {
                int count = letterCountMap.get(magazine.charAt(i));
                letterCountMap.put(magazine.charAt(i), ++count);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!letterCountMap.containsKey(ransomNote.charAt(i))) {
                return false;
            } else {
                int count = letterCountMap.get(ransomNote.charAt(i));

                if (count == 1) {
                    letterCountMap.remove(ransomNote.charAt(i));
                } else {
                    letterCountMap.put(ransomNote.charAt(i), --count);
                }
            }
        }

        return true;

    }
} */

//Optimized
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] alphabetCount = new int[26];

        for (char c : magazine.toCharArray()) {
            alphabetCount[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (alphabetCount[c - 'a'] == 0)
                return false;

            alphabetCount[c - 'a']--;
        }

        return true;
    }
}
// @lc code=end
