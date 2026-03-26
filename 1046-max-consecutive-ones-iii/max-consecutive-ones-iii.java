class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0;
        int zeros = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }

            //shrink window if invalid
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // valid window
            int len = right - left + 1;
            maxlen = Math.max(maxlen, len);

            right++;
        }
        return maxlen;        
    }
}