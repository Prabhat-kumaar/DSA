import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        boolean merged = true;

        while (merged) {
            merged = false;

            for (int i = 0; i < n; i++) {

                if (intervals[i][0] == -1) continue;

                for (int j = i + 1; j < n; j++) {

                    if (intervals[j][0] == -1) continue;

                    int s1 = intervals[i][0];
                    int e1 = intervals[i][1];
                    int s2 = intervals[j][0];
                    int e2 = intervals[j][1];

                    // overlap check
                    if (s2 <= e1 && s1 <= e2) {

                        intervals[i][0] = Math.min(s1, s2);
                        intervals[i][1] = Math.max(e1, e2);

                        intervals[j][0] = -1; 
                        merged = true;
                    }
                }
            }
        }

        List<int[]> ans = new ArrayList<>();

        for (int[] in : intervals) {
            if (in[0] != -1) ans.add(in);
        }

        return ans.toArray(new int[ans.size()][]);
    }
}