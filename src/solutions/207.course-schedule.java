package solutions;
/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incoming = new int[numCourses]; // Number of prerequisites for a node before we take up the i-th course.
        List<Integer>[] neigh = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            neigh[i] = new LinkedList<>();
        }

        for (int[] pair : prerequisites) {
            incoming[pair[0]]++;
            neigh[pair[1]].add(pair[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < incoming.length; i++) {
            if (incoming[i] == 0) {
                queue.add(i);
            }
        }

        int edgeCnt = prerequisites.length;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int course : neigh[cur]) {
                edgeCnt--;
                if (--incoming[course] == 0) {
                    queue.add(course);
                }
            }

        }

        return edgeCnt == 0;

    }
}
// @lc code=end
