class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int left = 0;
        int result = 0;
        
        for(int i = 0; i < nums.length; i++) {
            
            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[i]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(i);
            
            while(!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[i]) {
                minDeque.pollLast();
            }
            minDeque.addLast(i);
            
            int max = nums[maxDeque.peekFirst()];
            int min = nums[minDeque.peekFirst()];
            
            if(max - min > limit) {
                left++;
                if(maxDeque.peekFirst() < left) maxDeque.pollFirst();
                if(minDeque.peekFirst() < left) minDeque.pollFirst();
            }
            
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}