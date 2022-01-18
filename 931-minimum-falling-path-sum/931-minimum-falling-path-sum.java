class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int minans = Integer.MAX_VALUE;
        int [][] dp = new int[row][col];
        for(int i=0;i<col;i++){ // copying the first row into dp
            dp[0][i] = matrix[0][i];
        }
        
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                if(j==0) dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1]);
                else if(j==col-1) dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]);
                else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]);
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j+1]);
                }
                dp[i][j]+=matrix[i][j];
            }
        }
        for(int k=0;k<col;k++){
            minans = Math.min(minans,dp[row-1][k]);
        }
        return minans;
    }
}