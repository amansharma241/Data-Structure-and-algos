class Solution {
    public int uniquePathsWithObstacles(int[][] Grid) {
        int m = Grid.length;
        int n = Grid[0].length;
        int [][] dp = new int [m][n];
        int ans = helper(m-1,n-1,dp,Grid);
            return ans;
    }
    public static int helper(int row,int col,int [][] dp,int [][] Grid){
        if(row==0 && col==0 && Grid[0][0]!=1) return 1;
        //if(Grid[row][col]==1) return 0;
        if(row<0 || col<0 || Grid[row][col]==1) return 0;
        if(dp[row][col]!=0) return dp[row][col];
        return dp[row][col] = helper(row-1,col,dp,Grid) + helper(row,col-1,dp,Grid);
    
    }
}