class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int low = 1, high = 0;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isValid(nums,mid, threshold)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isValid(int[]nums, int d, int threshold) {
        int sum = 0;

        for (int num : nums) {
            sum += (num + d - 1) / d;
        }
        return sum  <= threshold;
    }
}