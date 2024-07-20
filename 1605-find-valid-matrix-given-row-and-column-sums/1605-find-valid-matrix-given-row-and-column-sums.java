class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= dp[i][j];
                colSum[j] -= dp[i][j];
            }
        }
        return dp;
    }
}