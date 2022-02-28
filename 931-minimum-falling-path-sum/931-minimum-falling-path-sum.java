class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        
        int [][] dp = new int[n][m];
        int minans = Integer.MAX_VALUE;
        
        for(int i=0;i<m;i++){
            minans = Math.min(minans,helper(n-1,i,matrix,dp));
        }
        return minans;
    }
    public int helper(int row,int col,int [][] matrix,int [][] dp){
        if(row==0 && col>=0 && col<matrix[0].length) return matrix[row][col];
        if(col<0 || col>matrix[0].length-1) return Integer.MAX_VALUE;
        if(dp[row][col]!=0) return dp[row][col];
        int top = helper(row-1,col,matrix,dp);
        int topleft = helper(row-1,col-1,matrix,dp);
        int topright = helper(row-1,col+1,matrix,dp);
        
       return dp[row][col] = matrix[row][col] + Math.min(topright,Math.min(top,topleft));
    }
}