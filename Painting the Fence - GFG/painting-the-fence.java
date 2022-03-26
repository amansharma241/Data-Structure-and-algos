// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution
{
    long countWays(int n,int k)
    {
        //code here.
        int mod = 1000000007;
        if(n==1) return k;
        if(n==2) return k*(k-1);
        
        long same = k;
        long different = k*(k-1);
        long total = same + different;
        
        for(int i=3;i<=n;i++){
            same = different;
            different = total * (k-1);
            total = (same + different)%mod;
        }
        return total;
    }
}




// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            //int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);

            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.countWays(n,k);
            System.out.println(ans);
        }
    }
}


  // } Driver Code Ends