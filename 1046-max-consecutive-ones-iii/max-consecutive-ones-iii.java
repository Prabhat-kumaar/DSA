class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, maxlen = 0, zeros = 0;

        while (right < nums.length) {

            if (nums[right] == 0) {
                zeros++;
            }

            if (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            int len = right - left + 1;
            maxlen = Math.max(maxlen, len);

            right++;
        }
        return maxlen;
    }
}