package solutions;
/*
 * @lc app=leetcode id=1339 lang=java
 *
 * [1339] Maximum Product of Splitted Binary Tree
 */

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
class Solution {
    public int maxProduct(TreeNode root) {

        if(root == null) return 0;

        long total = dfs(root);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        long ans = 0;
        long mod = 1000000007L;

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            long cur = (total - node.val) * node.val;
            ans = Math.max(ans, cur);

            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }

        return (int) (ans % mod);
        
    }

    private long dfs(TreeNode node) {
        if(node == null) return 0;

        node.val += dfs(node.left) + dfs(node.right);

        return node.val;
    }
}
// @lc code=end

