import java.util.*;

class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        int duplicate = -1;
        int missing = -1;

       
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        
        for (int i = 1; i <= nums.length; i++) {
            if (map.getOrDefault(i, 0) == 2) {
                duplicate = i;
            }
            if (!map.containsKey(i)) {
                missing = i;
            }
        }

       
        result.add(duplicate);
        result.add(missing);

       
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}