class Solution {
    public int mySqrt(int x) {
        int low = 1, high = x;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // To avoid overflow
            if ((long) mid * mid <= x) {
                ans = mid;        // store possible answer
                low = mid + 1;    // move right
            } else {
                high = mid - 1;   // move left
            }
        }

        return ans;
    }
}