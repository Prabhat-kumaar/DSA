import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> set = new HashSet<>();

        // Store all jewels
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;

        // Count jewels in stones
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}