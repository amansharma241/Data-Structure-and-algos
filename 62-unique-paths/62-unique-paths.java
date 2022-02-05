class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m][n];
        int ans = helper(m-1,n-1,dp);
            return ans;
    }
    public static int helper(int row,int col,int [][] dp){
        if(row==0 && col==0) return 1;
        if(row<0 || col<0) return 0;
        if(dp[row][col]!=0) return dp[row][col];
        return dp[row][col] = helper(row-1,col,dp) + helper(row,col-1,dp);
    }
}