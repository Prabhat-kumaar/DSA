import java.util.*;

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {

        List<Long> ans = new ArrayList<>();

        if (finalSum % 2 != 0) {
            return ans;
        }

        long num = 2;

        while (finalSum >= num) {
            ans.add(num);
            finalSum -= num;
            num += 2;
        }

        if (!ans.isEmpty()) {
            ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum);
        }

        return ans;
    }
}