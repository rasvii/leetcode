package solutions;
/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> children = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty() || !children.isEmpty()) {

            if (queue.isEmpty()) {
                while (!children.isEmpty()) {
                    queue.offer(children.poll());
                }
            }

            List<Integer> tmp = new ArrayList<>(queue.size());

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null)
                    children.offer(node.left);
                if (node.right != null)
                    children.offer(node.right);
            }

            result.add(tmp);
        }

        return result;

    }
}
/*
 * class Solution {
 * public List<List<Integer>> levelOrder(TreeNode root) {
 * 
 * List<List<Integer>> result = new ArrayList<>();
 * 
 * if (root == null) {
 * return result;
 * }
 * 
 * Queue<TreeNode> nodes = new LinkedList<>();
 * 
 * nodes.add(root);
 * 
 * while (!nodes.isEmpty()) {
 * List<Integer> levelNodes = new ArrayList<>();
 * 
 * int n = nodes.size();
 * 
 * for (int i = 0; i < n; i++) {
 * TreeNode node = nodes.poll();
 * levelNodes.add(node.val);
 * 
 * if (node.left != null) {
 * nodes.add(node.left);
 * }
 * if (node.right != null) {
 * nodes.add(node.right);
 * }
 * }
 * 
 * result.add(levelNodes);
 * }
 * 
 * return result;
 * 
 * }
 * }
 */
// @lc code=end
