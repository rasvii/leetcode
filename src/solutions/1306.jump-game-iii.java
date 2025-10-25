package solutions;
/*
 * @lc app=leetcode id=1306 lang=java
 *
 * [1306] Jump Game III
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];

        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int idx, boolean[] visited) {
        if(idx < 0 || idx >= arr.length || visited[idx]) return false;

        visited[idx] = true;
        if(arr[idx] == 0) return true;

        return dfs(arr, idx + arr[idx], visited) ||  dfs(arr, idx - arr[idx], visited);
    }
}

/* class Solution {
    public boolean canReach(int[] arr, int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int n = arr.length;
        boolean[] visited = new boolean[n];

        while (!q.isEmpty()) {

            int idx = q.poll();
            if (visited[idx])
                continue;

            visited[idx] = true;

            if (arr[idx] == 0)
                return true;

            int next = idx + arr[idx];
            if (next < n && !visited[next])
                q.offer(next);

            next = idx - arr[idx];
            if (next >= 0 && !visited[next])
                q.offer(next);
        }

        return false;

    }
} */
// @lc code=end
