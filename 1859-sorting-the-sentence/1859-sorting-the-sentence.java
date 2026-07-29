class Solution {
    public String sortSentence(String s) {

        String[] words = s.split(" ");
        String[] ans = new String[words.length];

        for (String word : words) {

            char ch = word.charAt(word.length() - 1);
            int index = ch - '0';

            String actualWord = word.substring(0, word.length() - 1);

            ans[index - 1] = actualWord;
        }

        return String.join(" ", ans);
    }
}