class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length;

       
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                pos.add(i);
            }
        }

        int[] ans = new int[queries.length];

       
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i];

            int low = 0;
            int high = pos.size() - 1;

           
            int targetIndex = k - 1;

           
            if (targetIndex >= 0 && targetIndex < pos.size()) {
                ans[i] = pos.get(targetIndex);
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }
}