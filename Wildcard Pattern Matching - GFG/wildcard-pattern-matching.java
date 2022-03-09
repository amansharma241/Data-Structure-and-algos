// { Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}// } Driver Code Ends


class Solution
{
    int wildCard(String pattern, String str)
    {
        // Your code goes here
        boolean ans = isMatch(str,pattern);
        if(ans==true) return 1;
        return 0;
        
    }
    public boolean isMatch(String s, String p) {
        boolean [][] dp  =new boolean[p.length()+1][s.length()+1];
        
        for(int i=0;i<=p.length();i++){
            for(int j=0;j<=s.length();j++){
                if(i==0 && j==0) dp[i][j] = true;
                else if(i==0) dp[i][j] = false;
                else if(j==0){
                    if(p.charAt(i-1)=='*') dp[i][j]  = dp[i-1][j];
                    else dp[i][j] = false;
                }
                else{
                    if(s.charAt(j-1)==p.charAt(i-1) || p.charAt(i-1)=='?') dp[i][j] = dp[i-1][j-1];
                    else if (p.charAt(i-1)=='*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    else dp[i][j] = false;
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
