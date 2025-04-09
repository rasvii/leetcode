package solutions;
/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(postorder.length - 1, 0, inorder.length - 1, postorder);
    }

    private TreeNode helper(int postEnd, int inStart, int inEnd, int[] postorder) {

        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = inorderMap.get(root.val);

        root.right = helper(postEnd - 1, index + 1, inEnd, postorder);
        root.left = helper(postEnd - inEnd + index - 1, inStart, index - 1, postorder);

        return root;
    }
}
// @lc code=end
