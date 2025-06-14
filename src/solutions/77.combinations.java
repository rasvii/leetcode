package solutions;/*
                  * @lc app=leetcode id=77 lang=java
                  *
                  * [77] Combinations
                  */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, new ArrayList<>(), k, result);
        return result;
    }

    private void backtrack(int start, int n, List<Integer> comb, int k, List<List<Integer>> result) {

        if (comb.size() == k) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(i + 1, n, comb, k, result);
            comb.remove(comb.size() - 1);
        }

    }
}
// @lc code=end
