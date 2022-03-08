// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] nums, int n) {
        // code here
         if(nums==null) return 0;
        long max = nums[0];
        long min = nums[0];
        long result = nums[0];
        
        for(int i=1;i<nums.length;i++){
            long temp = max;
            max = Math.max(max*nums[i],Math.max(min*nums[i],nums[i]));
            min = Math.min(temp*nums[i],Math.min(min*nums[i],nums[i]));
            if(max>result) result = max;
        }
        return result; 
    }
}