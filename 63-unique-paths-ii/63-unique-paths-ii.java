class Solution {
    public int uniquePathsWithObstacles(int[][] Grid) {
        int m = Grid.length;
        int n = Grid[0].length;
        int [][] dp = new int [m][n];
        //dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              if(Grid[i][j]==1) dp[i][j]=0;
              else if(i==0 && j==0) dp[i][j] = 1;
              else if(i>0 && j>0) dp[i][j] = dp[i-1][j] + dp[i][j-1];
                else if(i>0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i][j-1];
            }
        }
        //return dp[m-1][n-1];
         int ans = helper(m-1,n-1,dp,Grid);
         return ans;
    }
    public static int helper(int row,int col,int [][] dp,int [][] Grid){
        if(row<0 || col<0 || Grid[row][col]==1) return 0;
        if(row==0 && col==0 ) return 1;
        
        if(dp[row][col]!=0) return dp[row][col];
        return dp[row][col] = helper(row-1,col,dp,Grid) + helper(row,col-1,dp,Grid);
    
    }
}