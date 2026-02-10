package solutions;
/*
 * @lc app=leetcode id=1382 lang=java
 *
 * [1382] Balance a Binary Search Tree
 */

// @lc code=start

import java.util.*;

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
    public TreeNode balanceBST(TreeNode root) {
        
        List<Integer> inorder= new ArrayList<>();
        inorder(root, inorder);
        return construct(inorder, 0, inorder.size() -1);
    }

    private void inorder(TreeNode root, List<Integer> inorder) {
        if(root== null) return;

        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }

    private TreeNode construct(List<Integer> inorder, int start, int end){
        if(start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode left = construct(inorder, start, mid-1);
        TreeNode right= construct(inorder, mid+1, end);

        TreeNode node = new TreeNode(inorder.get(mid), left, right);

        return node;
    }
}
// @lc code=end

