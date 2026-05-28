class Solution {
    int lower, upper;
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        
        long[] prefixSums = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        return mergeSort(prefixSums, 0, prefixSums.length - 1);
    }
    
    private int mergeSort(long[] arr, int left, int right) {
        if(left >= right) return 0;
        
        int mid = left + (right - left) / 2;
        int count = mergeSort(arr, left, mid) + 
                    mergeSort(arr, mid + 1, right);
        
        int j = mid + 1, k = mid + 1;
        for(int i = left; i <= mid; i++) {
            while(k <= right && arr[k] - arr[i] < lower) k++;
            while(j <= right && arr[j] - arr[i] <= upper) j++;
            count += j - k;
        }
        
        // merge step
        long[] sorted = new long[right - left + 1];
        int p1 = left, p2 = mid + 1, idx = 0;
        while(p1 <= mid && p2 <= right) {
            sorted[idx++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid) sorted[idx++] = arr[p1++];
        while(p2 <= right) sorted[idx++] = arr[p2++];
        
        for(int i = 0; i < sorted.length; i++) {
            arr[left + i] = sorted[i];
        }
        return count;
    }
}