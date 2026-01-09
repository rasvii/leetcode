package solutions;
/*
 * @lc app=leetcode id=865 lang=java
 *
 * [865] Smallest Subtree with all the Deepest Nodes
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int depth1 = depth(root.left), depth2 = depth(root.right);
        if(depth1 == depth2) {
            return root;
        }
        if(depth1 > depth2) {
            return subtreeWithAllDeepest(root.left);
        }
        return subtreeWithAllDeepest(root.right);
    }

    private int depth(TreeNode root) {
        if(root != null) {
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
        return 0;
    }
}
// @lc code=end

