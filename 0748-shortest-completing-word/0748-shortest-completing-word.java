class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        int[] target = new int[26];

        for (char ch : licensePlate.toCharArray()) {
            if (Character.isLetter(ch)) {
                target[Character.toLowerCase(ch) - 'a']++;
            }
        }

        String ans = null;

        for (String word : words) {

            int[] freq = new int[26];

            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            boolean valid = true;

            for (int i = 0; i < 26; i++) {
                if (freq[i] < target[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid && (ans == null || word.length() < ans.length())) {
                ans = word;
            }
        }

        return ans;
    }
}