package solutions;
/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int sum) {
        if (node == null)
            return 0;

        if (node.right == null && node.left == null) {
            return sum * 10 + node.val;
        }

        return sum(node.left, sum * 10 + node.val) + sum(node.right, sum * 10 + node.val);
    }
}
// @lc code=end
