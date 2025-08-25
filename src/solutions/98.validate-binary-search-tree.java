/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start

import java.util.Stack;

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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        TreeNode curr = root, prev = null;

        Stack<TreeNode> stack = new Stack<>();

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();

            if (prev != null && curr.val <= prev.val)
                return false;
            prev = curr;
            curr = curr.right;
        }

        return true;
    }
}

/*
 * class Solution {
 * 
 * private TreeNode prev = null;
 * 
 * public boolean isValidBST(TreeNode root) {
 * 
 * if (root == null) {
 * return true;
 * }
 * 
 * if (!isValidBST(root.left)) {
 * return false;
 * }
 * 
 * if (prev != null && prev.val >= root.val) {
 * return false;
 * }
 * 
 * prev = root;
 * 
 * if (!isValidBST(root.right)) {
 * return false;
 * }
 * 
 * return true;
 * 
 * }
 * }
 */
// @lc code=end
