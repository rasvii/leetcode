package solutions;
/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        postorder(result, root);
        return result;
    }

    private void postorder(List<Integer> result, TreeNode root) {
        if (root != null) {
            postorder(result, root.left);
            postorder(result, root.right);
            result.add(root.val);
        }
    }

    // Traversal
    /*
     * public List<Integer> postorderTraversal(TreeNode root) {
     * if(root == null) return new ArrayList<>();
     * List<Integer> result = new ArrayList<>();
     * 
     * Stack<TreeNode> stack1 = new Stack<>();
     * Stack<TreeNode> stack2 = new Stack<>();
     * stack1.push(root);
     * TreeNode curr;
     * 
     * while(!stack1.isEmpty()){
     * curr = stack1.pop();
     * stack2.push(curr);
     * 
     * if(curr.left != null) stack1.push(curr.left);
     * if(curr.right != null) stack1.push(curr.right);
     * }
     * 
     * while(!stack2.isEmpty()){
     * result.add(stack2.pop().val);
     * }
     * return result;
     * }
     */
}
// @lc code=end
