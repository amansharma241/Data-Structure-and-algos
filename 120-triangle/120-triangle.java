class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [][] dp = new int [triangle.size()][triangle.get(triangle.size()-1).size()];
        if(triangle==null) return 0;
        int row = triangle.size();
        int col = triangle.get(triangle.size()-1).size();
       // int ans = helper(0,0,triangle,dp);
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            dp[dp.length-1][i] = triangle.get(dp.length-1).get(i);
        }
        
        for(int i=row-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
        //return ans;
    }
    public static int helper(int row,int col,List<List<Integer>> triangle,int [][] dp){
        int n = triangle.size();
        if(row==n-1) return triangle.get(n-1).get(col);
        if(dp[row][col]!=0) return dp[row][col];
        int down = triangle.get(row).get(col) + helper(row+1,col,triangle,dp);
        int diag = triangle.get(row).get(col) + helper(row+1,col+1,triangle,dp);
        
        return dp[row][col] = Math.min(down,diag);
    }
}