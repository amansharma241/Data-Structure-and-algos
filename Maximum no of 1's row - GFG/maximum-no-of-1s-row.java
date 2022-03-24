// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][]arr = new int[n][m];
            
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    arr[i][j] = sc.nextInt ();

    		System.out.println (new Sol().maxOnes (arr, n, m));
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int maxOnes (int Mat[][], int N, int M)
    {
        // your code here
        if(Mat==null) return 0;
        int num = 0;
        int ansind = -1;
        for(int i=0;i<Mat.length;i++){
            int temp = findOnes(Mat[i]);
            if(num<temp){
                ansind = i;
                num = temp;
            }
        }
        return ansind;
    }
    public static int findOnes(int [] arr){
        if(arr==null) return 0;
        
        //int ans = 0;
        int lo = 0;
        int hi = arr.length-1;
        int ind = 0;
        boolean flag = false;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]==1){
                flag = true;
                ind = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        if(flag==true) return arr.length-ind;
        return 0;
    }
}