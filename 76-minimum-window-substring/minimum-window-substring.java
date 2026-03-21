class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) return "";

        int[] tFreq = new int[128];
        int[] windowFreq = new int[128];

        // store frequency of t
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int required = 0; // unique chars in t
        for (int i = 0; i < 128; i++) {
            if (tFreq[i] > 0) required++;
        }

        int formed = 0;

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            windowFreq[c]++;

            // if current char matches required frequency
            if (tFreq[c] > 0 && windowFreq[c] == tFreq[c]) {
                formed++;
            }

            // try to shrink window
            while (left <= right && formed == required) {

                // update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char ch = s.charAt(left);
                windowFreq[ch]--;

                // if condition breaks
                if (tFreq[ch] > 0 && windowFreq[ch] < tFreq[ch]) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}