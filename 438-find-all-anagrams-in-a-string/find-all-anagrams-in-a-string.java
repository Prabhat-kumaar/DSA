class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        
        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
        }

      
        if (pMap.equals(windowMap)) result.add(0);

       
        for (int left = 1; left <= s.length() - p.length(); left++) {
            int right = left + p.length() - 1;

           
            char addChar = s.charAt(right);
            windowMap.put(addChar, windowMap.getOrDefault(addChar, 0) + 1);

           
            char removeChar = s.charAt(left - 1);
            windowMap.put(removeChar, windowMap.get(removeChar) - 1);
            if (windowMap.get(removeChar) == 0) {
                windowMap.remove(removeChar);
            }

           
            if (pMap.equals(windowMap)) result.add(left);
        }

        return result;
    }
}