class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            int daysUsed = 1;
            int currentLoad = 0;

            for (int weight : weights) {

                if (currentLoad + weight > mid) {
                    daysUsed++;
                    currentLoad = 0;
                }

                currentLoad += weight;
            }

            if (daysUsed > days) {
                low = mid + 1;  
            } else {
                high = mid;     
            }
        }

        return low;
    }
}