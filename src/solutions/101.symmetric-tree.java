package solutions;
/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.right, root.left);
    }

    private boolean isSymmetricHelp(TreeNode right, TreeNode left) {

        if (right == null || left == null) {
            return right == left;
        }

        if (right.val != left.val) {
            return false;
        }

        return isSymmetricHelp(right.left, left.right) && isSymmetricHelp(right.right, left.left);
    }
}
// @lc code=end
