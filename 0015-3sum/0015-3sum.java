class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        //Step 1: Sort the array
        Arrays.sort(nums);

        //Step 2: Fix one number
        for(int i = 0; i<nums.length-2; i++) {
            
            //skip duplicate fixed numbers
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            // step 3 : Two pointer approach
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i],
                    nums[left],
                    nums[right]
                    ));

                    left++;
                    right--;

                    // skip duplicate left values
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                        // skip duplicate left values
                     while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else if (sum < 0) {

                    // Need a larger sum
                    left++;
                } else {
                    // need a smaller sum
                    right--;
                }
            }
        }
        return result;
    }
}