class Solution {
    public int minPathSum(int[][] grid) {
        // iterative solution
//         int [][] dp = new int[grid.length][grid[0].length];
//         dp[0][0] = grid[0][0];
//         for(int i=0;i<dp.length;i++){
//             for(int j=0;j<dp[0].length;j++){
//                 if(i>0 && j>0) dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
//                 else if(i>0) dp[i][j] = grid[i][j] + dp[i-1][j];
//                 else if(j>0) dp[i][j] = grid[i][j] + dp[i][j-1];
                
//             }
//         }
//         return dp[dp.length-1][dp[0].length-1];
    
        //recursive solution
        int [][] dp = new int[grid.length][grid[0].length];
        int ans = helper(dp,grid,dp.length-1,dp[0].length-1);
        return ans;
    }
    public static int helper(int [][] dp,int [][] grid,int row,int col){
        if(row==0 && col==0) return grid[0][0];
        
        if(row<0 || col<0) return Integer.MAX_VALUE;
        if(dp[row][col]!=0) return dp[row][col];
        
        int up = helper(dp,grid,row-1,col);
        int left = helper(dp,grid,row,col-1);
        
        return dp[row][col] = Math.min(up,left) + grid[row][col];
    }
}