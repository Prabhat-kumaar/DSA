class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int i = 0, j = 0;
        int x = 0, y = 0;

        while (i < word1.length && x < word2.length) {

            if (word1[i].charAt(j) != word2[x].charAt(y)) {
                return false;
            }

            j++;
            y++;

            if (j == word1[i].length()) {
                i++;
                j = 0;
            }

            if (y == word2[x].length()) {
                x++;
                y = 0;
            }
        }

        return i == word1.length && x == word2.length;
    }
}