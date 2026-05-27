class Solution {
    public int minSubarray(int[] nums, int p) {
        
        long totalSum = 0;
        for(int num : nums) totalSum += num;
        int rem = (int)(totalSum % p);
        if(rem == 0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        long prefixSum = 0;
        int result = nums.length;
        
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int currRem = (int)(prefixSum % p);
            int target = (currRem - rem + p) % p;
            
            if(map.containsKey(target)) {
                result = Math.min(result, i - map.get(target));
            }
            map.put(currRem, i);
        }
        return result >= nums.length ? -1 : result;
    }
}