package solutions;
/*
 * @lc app=leetcode id=1823 lang=java
 *
 * [1823] Find the Winner of the Circular Game
 */

import java.util.ArrayList;

// @lc code=start
class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> friends = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }

        int currIdx = 0;

        while (friends.size() > 1) {
            int len = friends.size();
            int index = (currIdx + k - 1) % len;
            friends.remove(index);
            currIdx = index;
        }

        return friends.get(0);
    }
}
// @lc code=end
