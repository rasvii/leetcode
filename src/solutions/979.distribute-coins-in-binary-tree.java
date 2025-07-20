package solutions;
/*
 * @lc app=leetcode id=979 lang=java
 *
 * [979] Distribute Coins in Binary Tree
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

    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int coin = dfs(node.left) + dfs(node.right);

        if (node.val == 0)
            coin += -1;
        else
            coin += node.val - 1;

        moves += Math.abs(coin);

        return coin;
    }
}
// @lc code=end
