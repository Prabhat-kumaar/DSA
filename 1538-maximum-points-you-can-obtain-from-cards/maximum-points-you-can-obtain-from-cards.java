class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int lsum = 0;
        int rsum = 0;

        for (int i = 0; i < k; i++) {
            lsum +=cardPoints[i];
        }

        int maxSum = lsum;

        for(int i=0; i<k; i++) {
            lsum -=cardPoints[k - 1 -i];
            rsum +=cardPoints[n - 1 - i];

            maxSum = Math.max(maxSum, lsum + rsum);
        }
        return maxSum;
        
    }
}