class Solution {
    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {

            HashSet<Character> set = new HashSet<>();

            for (char ch : s.toCharArray()) {

                if (set.contains(ch)) {
                    return true;
                }

                set.add(ch);
            }

            return false;
        }

        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
            }
        }

        if (diff.size() != 2) {
            return false;
        }

        int i = diff.get(0);
        int j = diff.get(1);

        return s.charAt(i) == goal.charAt(j)
            && s.charAt(j) == goal.charAt(i);
    }
}