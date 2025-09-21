package solutions;
/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node neigh : cur.neighbors) {

                if (!map.containsKey(neigh)) {
                    map.put(neigh, new Node(neigh.val));
                    q.offer(neigh);
                }

                map.get(cur).neighbors.add(map.get(neigh));
            }
        }

        return map.get(node);
    }
}
// @lc code=end
