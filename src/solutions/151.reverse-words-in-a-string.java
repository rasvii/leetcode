package solutions;
/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {

        s = s.trim();
        String[] wordArr = s.split(" ");
        StringBuffer result = new StringBuffer();

        for (int i = wordArr.length - 1; i >= 0; i--) {

            if (wordArr[i] != "") {
                result.append(wordArr[i]);
                result.append(" ");
            }
        }

        return result.toString().trim();

    }
}
// @lc code=end
