class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        double len = Math.sqrt(n);
        int size = (int)len;
        int [] squares = new int [size+1];
        
        for(int i=0;i<=size;i++){
            squares[i] = i*i;
        }
      int ans = helper(n,squares,dp);
        return ans;
    }
    public int helper(int n,int [] squares,int [] dp){
        if(n<0) return Integer.MAX_VALUE;
        if(n==0) return 0;
        if(dp[n]!=0) return dp[n];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<squares.length;i++){
            min = Math.min(min,helper(n-squares[i],squares,dp));
        }
        return dp[n] = min+1;
    }
}