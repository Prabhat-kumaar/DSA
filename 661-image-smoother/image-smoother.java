class Solution {

    int[][] dir = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},  {0,0},  {0,1},
            {1,-1},  {1,0},  {1,1}
    };

    public int[][] imageSmoother(int[][] img) {

        int n = img.length;
        int m = img[0].length;

        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                int sum = 0;
                int count = 0;

                for (int[] d : dir) {

                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) {

                        sum += img[ni][nj];
                        count++;
                    }
                }

                int avg = sum / count;

                ans[i][j] = avg;
            }
        }

        return ans;
    }
}