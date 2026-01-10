package solutions;
/*
 * @lc app=leetcode id=1161 lang=java
 *
 * [1161] Maximum Level Sum of a Binary Tree
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
    public int maxLevelSum(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        int maxSum = Integer.MIN_VALUE;
        int result = 0;
        int level = 0;
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            int sum = 0;

            while(size-- > 0) {
                
                TreeNode node = q.poll();

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

                sum += node.val;
            }

            if(sum > maxSum) {
                maxSum = sum;
                result = level;
            }
        }

        return result;
    }
}

// class Solution {
//     public int maxLevelSum(TreeNode root) {
//         List<Integer> sum = new ArrayList<>();
//         dfs(root, 0, sum);

//         int result = 0;
//         int maxSum = Integer.MIN_VALUE;
//         for(int i =0; i < sum.size(); i++) {
//             if(maxSum < sum.get(i)) {
//                 maxSum = sum.get(i);
//                 result = i + 1;
//             }
//         }
//         return result;
//     }

//     private void dfs(TreeNode root, int level, List<Integer> sum) {
//         if(root == null) return;

//         if(level == sum.size()) {
//             sum.add(0);
//         }

//         sum.set(level, sum.get(level) + root.val);
//         dfs(root.left, level +1, sum);
//         dfs(root.right, level + 1, sum);
//     }
// }
// @lc code=end

