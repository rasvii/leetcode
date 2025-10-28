package solutions;
/*
 * @lc app=leetcode id=1557 lang=java
 *
 * [1557] Minimum Number of Vertices to Reach All Nodes
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] incoming = new int[n];

        for (List<Integer> edge : edges) {
            incoming[edge.get(1)]++;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (incoming[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}
// @lc code=end
