// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int nums[])
    {
        // code here
         int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return 0;
        boolean ans =  helper(nums,N,sum/2);
        if(ans==true) return 1;
        return 0;
    }
    public static boolean helper(int [] nums,int n,int sum){
        boolean [][] dp = new boolean [sum+1][n+1];
        for(int i=0;i<=sum;i++){
            dp[i][0] = false;
        }
        for(int i=1;i<=n;i++){
            dp[0][i] = true;
        }
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                if(nums[j-1]>i) dp[i][j] = dp[i][j-1];
                else dp[i][j] = dp[i][j-1] || dp[i-nums[j-1]][j-1];
            }
        }
        return dp[sum][n];
    }
}