package solutions;
/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start

import java.util.*;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result, int level) {
        if (root == null)
            return;

        if (level == result.size()) {
            result.add(root.val);
        }

        dfs(root.right, result, level + 1);
        dfs(root.left, result, level + 1);
    }
}
/*
 * class Solution {
 * public List<Integer> rightSideView(TreeNode root) {
 * 
 * List<Integer> result = new ArrayList<>();
 * if (root == null)
 * return result;
 * Deque<TreeNode> q = new ArrayDeque<>();
 * q.add(root);
 * 
 * while (!q.isEmpty()) {
 * int size = q.size();
 * result.add(q.peekLast().val);
 * 
 * while (size-- > 0) {
 * TreeNode node = q.poll();
 * 
 * if (node.left != null)
 * q.add(node.left);
 * 
 * if (node.right != null)
 * q.add(node.right);
 * }
 * }
 * return result;
 * }
 * }
 */
// @lc code=end
