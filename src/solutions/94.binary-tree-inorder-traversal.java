package solutions;
/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }
}

// recursive
/*
 * class Solution {
 * 
 * public List<Integer> inorderTraversal(TreeNode root) {
 * List<Integer> result = new ArrayList<>();
 * 
 * inorder(root, result);
 * return result;
 * }
 * 
 * private void inorder(TreeNode node, List<Integer> result) {
 * if(node == null) return;
 * 
 * inorder(node.left, result);
 * result.add(node.val);
 * inorder(node.right, result);
 * }
 * }
 */
// @lc code=end
