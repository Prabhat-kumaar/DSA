class Solution {
    public boolean halvesAreAlike(String s) {
        int first = 0;
        int second = 0;
        int mid = s.length() / 2;

        for (int i = 0; i < s.length(); i++) {

            if (isVowel(s.charAt(i))) {

                if (i < mid) {
                    first++;
                } else {
                    second++;
                }
            }
        }
        return first == second;
    }

    private boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' ||
                ch == 'O' || ch == 'U';
    }
}