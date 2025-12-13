package solutions;

import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Set<String> categories = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        String[] priorities = { "electronics", "grocery", "pharmacy", "restaurant" };

        List<String> result = new ArrayList<>();
        int n = code.length;

        Map<String, List<String>> map = Map.of(
                "electronics", new ArrayList<>(),
                "grocery", new ArrayList<>(),
                "pharmacy", new ArrayList<>(),
                "restaurant", new ArrayList<>());

        for (int i = 0; i < n; i++) {
            if (isActive[i] && categories.contains(businessLine[i]) && isCouponValid(code[i])) {
                map.get(businessLine[i]).add(code[i]);
            }
        }

        for (String priority : priorities) {
            List<String> values = map.getOrDefault(priority, new ArrayList<>());

            if (values.isEmpty())
                continue;

            Collections.sort(values);
            result.addAll(values);
        }

        return result;
    }

    private boolean isCouponValid(String coupon) {
        return !coupon.isEmpty() && coupon.matches("[a-zA-Z0-9_]+");
    }
}