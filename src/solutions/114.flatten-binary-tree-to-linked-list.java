package solutions;
/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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

    public void flatten(TreeNode root) {
        flattenTree(root, null);
    }

    private TreeNode flattenTree(TreeNode node, TreeNode prev) {
        if (node == null) {
            return prev;
        }

        prev = flattenTree(node.right, prev);
        prev = flattenTree(node.left, prev);

        node.right = prev;
        node.left = null;
        prev = node;
        return prev;
    }
}
// @lc code=end
