package solutions;
/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 */

import java.util.*;

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
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();

        if (root == null)
            return result;

        nodes.add(root);

        while (!nodes.isEmpty()) {
            int n = nodes.size();
            double sum = 0.0;

            for (int i = 0; i < n; i++) {
                TreeNode node = nodes.poll();

                sum = sum + node.val;
                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }

            result.add(sum / n);
        }

        return result;

    }
}
// @lc code=end
