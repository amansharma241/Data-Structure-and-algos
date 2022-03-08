// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        if (s1.length()==0 || s2.length()==0) return 0;
        int [][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0;i<=s1.length();i++){
            for(int j = 0;j<=s2.length();j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else{
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
            }
        }
        return dp[x][y];
        //return helper(s1,s2,0,0,dp);
    }
    public static int helper(String s1, String s2,int i,int j,int [][] dp){
        if(i>=s1.length() || j>=s2.length()) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        
        
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = 1 + helper(s1,s2,i+1,j+1,dp);
        else return dp[i][j] =  Math.max(helper(s1,s2,i+1,j,dp),helper(s1,s2,i,j+1,dp));
    }
    
}