package solutions;
/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start

import java.util.HashMap;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);

    }

    public TreeNode helper(int preStart, int preEnd, int inStart, int inEnd,
            int[] preorder, int[] inorder) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inRoot = i;
                break;
            }
        }

        root.left = helper(preStart + 1, preEnd + inRoot - inStart, inStart, inRoot - 1, preorder, inorder);
        root.right = helper(preStart + inRoot - inStart + 1, preEnd, inRoot + 1, inEnd, preorder, inorder);

        return root;
    }
}
// @lc code=end
