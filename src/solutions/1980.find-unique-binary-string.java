package solutions;
/*
 * @lc app=leetcode id=1980 lang=java
 *
 * [1980] Find Unique Binary String
 */

// @lc code=start
import java.util.*;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        String[] bi = {"0", "1"};
        Set<String> strings = new HashSet<>();
        backtrack(0, bi, nums.length, strings, new StringBuilder());
        Set<String> numsSet = new HashSet<>(Arrays.asList(nums));

        for(String n : strings) {
            if(!numsSet.contains(n)) return n;
        }

        return null;
    }

    private void backtrack(int idx, String[] bi, int n, Set<String> strings, StringBuilder sb) {

        if(sb.length() == n) {
            strings.add(sb.toString());
            return;
        }

        for(int i = idx; i < 2; i++) {
            sb.append(bi[i]);
            backtrack(i, bi, n, strings, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
/* 
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<nums.length;i++)
        {
            sb.append(nums[i].charAt(i) == '0'? "1": "0");
        }
        return new String(sb);
    }
}


class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        String[] bi = {"0", "1"};
        Set<String> numsSet = new HashSet<>(Arrays.asList(nums));

        return backtrack(0, bi, nums.length, new StringBuilder(), numsSet);
    }

    private String backtrack(int idx, String[] bi, int n, StringBuilder sb, Set<String> numsSet) {

        if(sb.length() == n) {
            String result = sb.toString();
            if(!numsSet.contains(result)) return result;
            return null;
        }

        for(int i = idx; i < 2; i++) {
            sb.append(bi[i]);
            String result = backtrack(i, bi, n, sb, numsSet);
            if(result != null) return result;
            sb.deleteCharAt(sb.length() - 1);
        }

        return null;
    }
} */
// @lc code=end

