package solutions;
/*
 * @lc app=leetcode id=2975 lang=java
 *
 * [2975] Maximum Square Area by Removing Fences From a Field
 */

// @lc code=start
class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        Set<Integer> hfences = getFences(hFences, m);
        Set<Integer> vfences = getFences(vFences, n);

        long result = 0;
        for(int e : hfences) {
            if(vfences.contains(e)) {
                result = Math.max(result, e);
            }
        }

        if(result == 0) {
            return -1;
        }

        return (int) ((result * result) % 1000000007);
    }

    private Set<Integer> getFences(int[] fencesArr, int border){
        Set<Integer> result= new HashSet<>();
        List<Integer> fences = new ArrayList<>();

        for(int i : fencesArr) {
            fences.add(i);
        }

        fences.add(1);
        fences.add(border);
        Collections.sort(fences);

        for(int i = 0; i < fences.size(); i++) {
            for(int j = i+1; j < fences.size(); j++) {
                result.add(fences.get(j) - fences.get(i));
            }
        }

        return result;
    }
}
// @lc code=end

