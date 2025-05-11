package solutions;
/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> visitedNums = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int secondNum = target - nums[i];

            if(visitedNums.containsKey(secondNum)){
                return new int[]{visitedNums.get(secondNum), i};
            }

            visitedNums.put(nums[i], i);
        }

        return new int[]{};

    }
}
// @lc code=end
