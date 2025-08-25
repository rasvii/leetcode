/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;

        Stack<TreeNode> stack = new Stack<>();

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (k == 1)
                break;
            k--;

            curr = curr.right;
        }

        return curr.val;
    }
}
/*
 * class Solution {
 * 
 * private int count = 0;
 * 
 * public int kthSmallest(TreeNode root, int k) {
 * TreeNode result = helper(root, k);
 * return result != null ? result.val : 0;
 * }
 * 
 * private TreeNode helper(TreeNode node, int k) {
 * 
 * if (node == null) {
 * return null;
 * }
 * 
 * TreeNode left = helper(node.left, k);
 * 
 * if (left != null) {
 * return left;
 * }
 * 
 * count++;
 * 
 * if (count == k) {
 * return node;
 * }
 * 
 * return helper(node.right, k);
 * }
 * }
 */
// @lc code=end
