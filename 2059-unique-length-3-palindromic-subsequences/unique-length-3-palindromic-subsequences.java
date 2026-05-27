class Solution {
    public int countPalindromicSubsequence(String s) {
        
        Set<Character> chars = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }
        
        int result = 0;
        
        for(char c : chars) {
            int first = s.indexOf(c);
            int last  = s.lastIndexOf(c);
            
            if(first < last) {
                Set<Character> middle = new HashSet<>();
                for(int i = first + 1; i < last; i++) {
                    middle.add(s.charAt(i));
                }
                result += middle.size();
            }
        }
        return result;
    }
}