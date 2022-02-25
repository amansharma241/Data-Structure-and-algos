class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0 && j>0) dp[i][j] = dp[i-1][j] + dp[i][j-1];
                else if(i>0) dp[i][j] = dp[i-1][j];
                else if(j>0) dp[i][j] = dp[i][j-1];
            }
        }
        //int ans = helper(m-1,n-1,dp);
            return dp[m-1][n-1];
    }
    public static int helper(int row,int col,int [][] dp){
        if(row==0 && col==0) return 1;
        if(row<0 || col<0) return 0;
        if(dp[row][col]!=0) return dp[row][col];
        return dp[row][col] = helper(row-1,col,dp) + helper(row,col-1,dp);
    }
}