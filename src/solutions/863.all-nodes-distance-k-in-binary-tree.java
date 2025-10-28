package solutions;
/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start

import java.util.*;

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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Map<Integer, TreeNode> parent = new HashMap<>();
        TreeNode targetNode = findParent(root, parent, target.val);

        if (targetNode == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(targetNode);
        Set<Integer> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode cur = q.poll();

                if (k == 0) {
                    result.add(cur.val);
                    continue;
                }

                visited.add(cur.val);

                TreeNode parentNode = parent.get(cur.val);

                if (parentNode != null && !visited.contains(parentNode.val)) {
                    q.offer(parentNode);
                }

                if (cur.left != null && !visited.contains(cur.left.val)) {
                    q.offer(cur.left);
                }

                if (cur.right != null && !visited.contains(cur.right.val)) {
                    q.offer(cur.right);
                }
            }

            if (k == 0)
                break;

            k--;
        }

        return result;
    }

    private TreeNode findParent(TreeNode root, Map<Integer, TreeNode> parent, int target) {
        if (root == null)
            return null;
        if (root.val == target) {
            return root;
        }
        if (root.left != null)
            parent.put(root.left.val, root);
        if (root.right != null)
            parent.put(root.right.val, root);

        TreeNode left = findParent(root.left, parent, target);
        if (left != null)
            return left;
        return findParent(root.right, parent, target);
    }
}
// @lc code=end
