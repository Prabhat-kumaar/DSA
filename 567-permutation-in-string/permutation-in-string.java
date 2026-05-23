class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

       
        for (int i = 0; i < s1.length(); i++) {
            char ch = s2.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
        }

       
        if (s1Map.equals(windowMap)) return true;

       
        for (int left = 1; left <= s2.length() - s1.length(); left++) {
            int right = left + s1.length() - 1; 

           
            char addChar = s2.charAt(right);  
            windowMap.put(addChar, windowMap.getOrDefault(addChar, 0) + 1);  

           
            char removeChar = s2.charAt(left - 1); 
            windowMap.put(removeChar, windowMap.get(removeChar) - 1);
            if (windowMap.get(removeChar) == 0) windowMap.remove(removeChar);

           
            if (s1Map.equals(windowMap)) return true;
        }

        return false;  
    }
}