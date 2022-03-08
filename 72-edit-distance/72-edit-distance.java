class Solution {
    public int minDistance(String word1, String word2) {
          int[][] dp = new int[word2.length()+1][word1.length()+1];
    for(int i = 0; i <= word2.length(); i++) {
        for(int j = 0; j <= word1.length(); j++) {
            if(i == 0 && j == 0) dp[i][j] = 0; // no strings given
            else if(i == 0 && j != 0) {
                dp[i][j] = j; // word2 is empty
            } else if(i != 0 && j == 0) {
                dp[i][j] = i; // word1 is empty
            } else if(word2.charAt(i-1) != word1.charAt(j-1)) {
                dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
            }else {
                dp[i][j] = dp[i-1][j-1]; // same characters just carry over previous chars from both
            }
        }
    }
    return dp[word2.length()][word1.length()];
        
        //return helper(s1,s2,0,0,dp); recursive solution....
        
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
   
}