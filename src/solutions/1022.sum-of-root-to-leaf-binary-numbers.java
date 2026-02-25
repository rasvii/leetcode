package solutions;
/*
 * @lc app=leetcode id=1022 lang=java
 *
 * [1022] Sum of Root To Leaf Binary Numbers
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
class Solution {
    private int result = 0;

    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);

        return result;    
    }

    private void helper(TreeNode root, int sum) {
        if(root == null) {
            result += sum;
            return;
        }

        sum = sum << 1;
        sum = sum | root.val;
        
        if(root.left == null && root.right == null) {
            result += sum;
            return;
        }
        else if(root.left == null) {
            helper(root.right, sum);
        }
        else {
            helper(root.left, sum);
            if(root.right != null) helper(root.right, sum);
        }

        return;
    }
}
// @lc code=end

