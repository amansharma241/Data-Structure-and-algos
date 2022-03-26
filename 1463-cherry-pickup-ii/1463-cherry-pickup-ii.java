class Solution {
    public int cherryPickup(int[][] grid) {
       if(grid==null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int [][][] dp = new int[m][n][n];
       return helper(0,0,n-1,grid,dp);
    }
    public int helper(int row,int col1,int col2,int [][] grid,int [][][] dp){
        if(col1<0 || col1>=grid[0].length || col2<0 || col2>=grid[0].length) return -100007;
        
        if(row==grid.length-1){
            if(col1==col2) return grid[row][col1];
            else return grid[row][col1] + grid[row][col2];
        }
        if(dp[row][col1][col2]!=0) return dp[row][col1][col2];
        int max = Integer.MIN_VALUE;
        for(int dj1 = -1 ;dj1<=1;dj1++){
            for(int dj2 = -1;dj2<=1;dj2++){
                int ans = 0;
                if(col1==col2) ans =  grid[row][col1] + helper(row+1,col1 + dj1,col2 + dj2,grid,dp);
                else ans = grid[row][col1] + grid[row][col2] + helper(row+1,col1 + dj1,col2 + dj2,grid,dp);
                
                max = Math.max(ans,max);
            }
        }
        return dp[row][col1][col2] = max;
    }
}