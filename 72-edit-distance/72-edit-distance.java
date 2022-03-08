class Solution {
    public int minDistance(String s1, String s2) {
        if(s1==null || s2==null) return 0;
        // int len = s1.length()>s2.length()? s1.length() : s2.length();
         int [][] dp = new int [s1.length()+1][s2.length()+1];
        // return len - lcs(s1,s2,0,0,dp);
        return helper(s1,s2,0,0,dp);
        
    } 
    public int helper(String s1,String s2,int i,int j,int [][] dp){
      if(i==s1.length()) return s2.length()-j;
      if(j==s2.length()) return s1.length()-i;
       if(dp[i][j]!=0) return dp[i][j];
       int mini = Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = helper(s1,s2,i+1,j+1,dp);
        else{
            int replace = 1 + helper(s1,s2,i+1,j+1,dp);
            int insert = 1 + helper(s1,s2,i,j+1,dp);
            int delete = 1 + helper(s1,s2,i+1,j,dp);
            mini = Math.min(Math.min(replace,insert),delete);
        }
        return dp[i][j] = mini;
    }
    // this is wrong code.....
    public int lcs(String s1,String s2,int i , int j,int [][] dp){
        if(i>=s1.length() || j>=s2.length()) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 1 + lcs(s1,s2,i+1,j+1,dp);
        }
        else{
            return dp[i][j] =  Math.max(lcs(s1,s2,i+1,j,dp),lcs(s1,s2,i,j+1,dp));
    }
    }
}