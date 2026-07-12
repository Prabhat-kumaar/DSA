class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            if(map.containsKey(num)) {
                int count = map.get(num);
                count++;
                map.put(num,count);
            } else {
                map.put(num,1);
            }

            if(map.get(num) > nums.length/2){
                return num;
            }
        }
        return -1;
    }
}