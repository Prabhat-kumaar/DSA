class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        
        if ((long)m * k > n) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        
        for (int d : bloomDay) {
            low = Math.min(low, d);
            high = Math.max(high, d);
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canMake(int[] bloomDay, int day, int m, int k) {
        int count = 0, bouquets = 0;

        for (int d : bloomDay) {
            if (d <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return bouquets >= m;
    }
}