class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int [26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]++;
        }

        for(int i = 0; i<s.length(); i++) {

            int idx = s.charAt(i) - 'a';
             
            if (freq[idx] == 1){
                return i;
            }
           
        }
        return -1;

    }
}