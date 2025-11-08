package solutions;
/*
 * @lc app=leetcode id=2528 lang=java
 *
 * [2528] Maximize the Minimum Powered City
 */

// @lc code=start
class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;

        // Binary search range: [0, totalStations + k]
        long low = 0;
        long high = k;
        for (int s : stations)
            high += s;

        // Array to simulate station additions
        long[] currentStations = new long[n];

        while (low <= high) {
            long targetPower = (low + high) / 2; // The min power we want to test
            long usedStations = 0; // How many new stations we've added
            long windowPower = 0; // Current sliding window sum

            // Reset the working copy
            for (int i = 0; i < n; i++) {
                currentStations[i] = stations[i];
            }

            // Initialize window with the first few cities (left half of radius)
            for (int i = 0; i < r; i++) {
                windowPower += currentStations[i];
            }

            // Traverse each city
            for (int city = 0; city < n && usedStations <= k; city++) {
                // Rightmost index this city's range can include
                int rightEdge = Math.min(n - 1, city + r);

                // Add new right city entering the window
                if (city + r < n) {
                    windowPower += currentStations[city + r];
                }

                // Remove left city leaving the window
                if (city - r - 1 >= 0) {
                    windowPower -= currentStations[city - r - 1];
                }

                // If this city's total power < targetPower, we must add stations
                long missingPower = Math.max(0, targetPower - windowPower);

                // Add new stations at the farthest right possible (helps future cities)
                currentStations[rightEdge] += missingPower;
                windowPower += missingPower;
                usedStations += missingPower;
            }

            // Check if we stayed within our station limit
            if (usedStations <= k) {
                // It’s possible to achieve this targetPower → try higher
                low = targetPower + 1;
            } else {
                // Too many stations needed → lower the target
                high = targetPower - 1;
            }
        }

        return high; // The largest achievable minimum power
    }
}

// @lc code=end
