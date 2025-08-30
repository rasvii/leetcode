package solutions;
/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return root;

        TreeNode cur = root;
        int min = Math.min(p.val, q.val), max = Math.max(p.val, q.val);

        while (cur != null) {
            if (cur.val > max) {
                cur = cur.left;
            } else if (cur.val < min) {
                cur = cur.right;
            } else {
                return cur;
            }
        }

        return null;
    }
}
// @lc code=end
