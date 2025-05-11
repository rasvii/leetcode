package solutions;
/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

import java.util.*;

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            if (nums[i] > 0)
                break;

            int j = i + 1, k = nums.length - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    //skip duplicates of j & k
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                }
                else if(sum < 0) {
                    j++;
                }
                else{
                    k--;
                }

            }
        }

        return new ArrayList<>(result);

    }
}

/*class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        int zeros = 0;

        for(int num : nums){
            if(num > 0){
                positive.add(num);
            }
            else if(num < 0){
                negative.add(num);
            }
            else{
                zeros++;
            }
        }

        Set<Integer> posSet = new HashSet<>(positive);
        Set<Integer> negSet = new HashSet<>(negative);

        if(zeros >= 3){
            result.add(Arrays.asList(0,0,0));
        }

        if(zeros > 0){
            for(int pos : positive){
                if(negSet.contains(-pos)){
                    result.add(Arrays.asList(pos, 0, -pos));
                }
            }
        }

        for(int i = 0; i < positive.size(); i++){
            for(int j = i + 1; j < positive.size(); j++){
                int neg = -(positive.get(i) + positive.get(j));
                if(negSet.contains(neg)){
                    List<Integer> triplet = Arrays.asList(positive.get(i), positive.get(j), neg);
                    Collections.sort(triplet);
                    result.add(triplet);
                }
            }
        }

        for(int i = 0; i < negative.size(); i++){
            for(int j = i + 1; j < negative.size(); j++){
                int pos = -(negative.get(i) + negative.get(j));
                if(posSet.contains(pos)){
                    List<Integer> triplet = Arrays.asList(negative.get(i), negative.get(j), pos);
                    Collections.sort(triplet);
                    result.add(triplet);
                }
            }
        }

        return new ArrayList<>(result);

    }
}*/
// @lc code=end
