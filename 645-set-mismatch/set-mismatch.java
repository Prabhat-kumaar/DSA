class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for (int i=1; i<=nums.length; i++) {
            if (map.getOrDefault(i,0) == 2) {
                result[0] = i;
            }
            if (!map.containsKey(i)) {
                result[1] = i; 
            }
        }
        return result;
    }
}