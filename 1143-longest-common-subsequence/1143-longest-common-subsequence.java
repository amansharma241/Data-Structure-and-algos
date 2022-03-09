class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length()+1][text2.length()+1];
        int ans = helper(text1.length(),text2.length(),text1,text2,dp);
        return ans;
    }
    
    // recursive solution
     public static int helper(int i,int j, String s1 , String s2,int [][] dp){
         if(i==0 || j==0){
             return 0;
         }
         if(dp[i][j]!=0){
             return dp[i][j];
         }
       else if(s1.charAt(i-1)==s2.charAt(j-1)){
           dp[i][j] = 1 + helper(i-1,j-1,s1,s2,dp);  
           return 1 + helper(i-1,j-1,s1,s2,dp);
         }
         else{
            int left = helper(i-1,j,s1,s2,dp);
             int right = helper(i,j-1,s1,s2,dp);
             dp[i][j] = Math.max(left,right); 
             return (Math.max(left,right));
         }
     }
}