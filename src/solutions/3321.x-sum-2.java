package solutions;

import java.util.*;

class Solution {

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Helper helper = new Helper(x);
        List<Long> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            helper.insert(nums[i]);
            if (i >= k) {
                helper.remove(nums[i - k]);
            }
            if (i >= k - 1) {
                ans.add(helper.getResult());
            }
        }

        return ans.stream().mapToLong(Long::longValue).toArray();
    }

}

class Helper {

    int x;
    TreeSet<Pair> large = new TreeSet<>();
    TreeSet<Pair> small = new TreeSet<>();
    Map<Integer, Integer> freq = new HashMap<>();
    private long result;

    public Helper(int x) {
        this.x = x;
    }

    public void insert(int num) {
        if (freq.containsKey(num) && freq.get(num) > 0) {
            Pair pair = new Pair(num, freq.get(num));
            if (pair.compareTo(large.first()) >= 0) {
                result -= (long) pair.num * pair.occ;
                large.remove(pair);
                if (!small.isEmpty()) {
                    Pair toAdd = small.last();
                    result += (long) toAdd.num * toAdd.occ;
                    small.remove(toAdd);
                    large.add(toAdd);
                }
            } else {
                small.remove(pair);
            }
        }
        freq.put(num, freq.getOrDefault(num, 0) + 1);
        Pair pair = new Pair(num, freq.get(num));
        if (large.size() < x || pair.compareTo(large.first()) > 0) {
            result += (long) pair.num * pair.occ;
            large.add(pair);
            if (large.size() > x) {
                Pair toRemove = large.first();
                result -= (long) toRemove.occ * toRemove.num;
                large.remove(toRemove);
                small.add(toRemove);
            }
        } else {
            small.add(pair);
        }
    }

    public void remove(int num) {
        Pair pair = new Pair(num, freq.get(num));
        if (pair.compareTo(large.first()) >= 0) {
            result -= (long) pair.num * pair.occ;
            large.remove(pair);
            if (!small.isEmpty()) {
                Pair toAdd = small.last();
                result += (long) toAdd.num * toAdd.occ;
                small.remove(toAdd);
                large.add(toAdd);
            }
        } else {
            small.remove(pair);
        }
        freq.put(num, freq.get(num) - 1);
        if (freq.get(num) > 0) {
            pair = new Pair(num, freq.get(num));
            if (large.size() < x || pair.compareTo(large.first()) > 0) {
                result += (long) pair.num * pair.occ;
                large.add(pair);
                if (large.size() > x) {
                    Pair toRemove = large.first();
                    result -= (long) toRemove.occ * toRemove.num;
                    large.remove(toRemove);
                    small.add(toRemove);
                }
            } else {
                small.add(pair);
            }
        }
    }

    public long getResult() {
        return result;
    }

    private static class Pair implements Comparable<Pair> {
        int num;
        int occ;

        public Pair(int num, int occ) {
            this.num = num;
            this.occ = occ;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.occ == other.occ) {
                return Integer.compare(this.num, other.num);
            } else {
                return Integer.compare(this.occ, other.occ);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return num == pair.num && occ == pair.occ;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, occ);
        }
    }
}
