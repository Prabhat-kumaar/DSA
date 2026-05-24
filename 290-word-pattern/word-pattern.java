class Solution {
    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(p) && !charToWord.get(p).equals(word)) return false;
            if (wordToChar.containsKey(word) && wordToChar.get(word) != p) return false;

            charToWord.put(p, word);
            wordToChar.put(word, p);
        }

        return true;
    }
}