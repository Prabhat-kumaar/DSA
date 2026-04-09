class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        int MOD = 1_000_000_007;
        int maxInv = n * (n - 1) / 2;

        // store constraints
        int[] req = new int[n + 1];
        for (int i = 0; i <= n; i++) req[i] = -1;

        for (int[] r : requirements) {
            req[r[0] + 1] = r[1]; // convert to length
        }

        int[][] dp = new int[n + 1][maxInv + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // prefix sum
            int[] prefix = new int[maxInv + 2];

            for (int j = 0; j <= maxInv; j++) {
                prefix[j + 1] = (prefix[j] + dp[i - 1][j]) % MOD;
            }

            for (int j = 0; j <= maxInv; j++) {
                int left = j - (i - 1);
                if (left < 0) left = 0;

                dp[i][j] = (prefix[j + 1] - prefix[left] + MOD) % MOD;
            }

            // 🔥 Apply constraint immediately
            if (req[i] != -1) {
                for (int j = 0; j <= maxInv; j++) {
                    if (j != req[i]) dp[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for (int j = 0; j <= maxInv; j++) {
            ans = (ans + dp[n][j]) % MOD;
        }

        return ans;
    }
}