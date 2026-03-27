class Solution {
    public int numberOfSubstrings(String s) {

        int n = s.length();
        int[] count = new int[3];

        int left = 0;
        int total = 0;

        for (int right = 0; right < n; right++) {

            // include current character
            count[s.charAt(right) - 'a']++;

            // shrink while valid
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {

                total += (n - right);  

                // remove left character
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return total;
    }
}