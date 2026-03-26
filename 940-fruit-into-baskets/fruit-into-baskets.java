import java.util.*;

class Solution {
    public int totalFruit(int[] arr) {
        
        int left = 0, right = 0, maxLen = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        while (right < arr.length) {

            // add fruit
            mpp.put(arr[right], mpp.getOrDefault(arr[right], 0) + 1);

            // if more than 2 types → shrink
            while (mpp.size() > 2) {

                mpp.put(arr[left], mpp.get(arr[left]) - 1);

                if (mpp.get(arr[left]) == 0) {
                    mpp.remove(arr[left]);
                }

                left++;
            }

            // update max length
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}