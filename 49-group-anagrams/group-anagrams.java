class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++) {

            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            map.computeIfAbsent(key, k-> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}