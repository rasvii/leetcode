package solutions;
/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<TreeNode>> memo = new HashMap<>();

        return helper(1, n, memo);   
    }

    private List<TreeNode> helper(int start, int end, Map<String, List<TreeNode>> memo) {

        String key = start+"-" + end;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        List<TreeNode> trees = new ArrayList<>();

        if(start > end) {
            trees.add(null);
            return trees;
        }

        for(int idx = start; idx <= end; idx++) {
            List<TreeNode> left = helper(start, idx -1, memo);
            List<TreeNode> right = helper(idx+1, end, memo);

            for(TreeNode leftTree: left) {
                for(TreeNode rightTree: right){
                    TreeNode node = new TreeNode(idx);
                    node.left = leftTree;
                    node.right = rightTree;
                    trees.add(node);
                }
            }
        }

        memo.put(key, trees);
        return trees;

    }
}
// @lc code=end

