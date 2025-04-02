package solutions;
/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> nodes = new LinkedList<>();

        nodes.add(root);
        boolean isOddLevel = false;

        while (!nodes.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();

            int size = nodes.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                levelNodes.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }

            if (!levelNodes.isEmpty()) {
                if (isOddLevel) {
                    Collections.reverse(levelNodes);
                }
                result.add(levelNodes);
            }
            // result.add(levelNodes);
            isOddLevel = !isOddLevel;
        }

        return result;

    }
}
// @lc code=end
