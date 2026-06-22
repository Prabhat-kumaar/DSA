class Solution {
    public int[] sortedSquares(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int[] result = new int[nums.length];

        int index = nums.length - 1;

        while (left <= right) {

            int leftsqrt = nums[left] * nums[left];
            int rightsqrt = nums[right] * nums[right];

            if (leftsqrt > rightsqrt) {

                result[index] = leftsqrt;
                left++;

            } else {

                result[index] = rightsqrt;
                right--;

            }

            index--;
        }

        return result;
    }
}