class Solution {
    public int splitArray(int[] nums, int k) {

        int low = 0, high = 0;

        for (int num : nums) {
            low = Math.max(low, num); 
            high += num;              
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                ans = mid;        
                high = mid - 1;   
            } else {
                low = mid + 1;    
            }
        }

        return ans;
    }

   
    public boolean canSplit(int[] nums, int k, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                subarrays++;      
                currentSum = num; 

                if (subarrays > k) return false; 
            }
        }

        return true;
    }
}