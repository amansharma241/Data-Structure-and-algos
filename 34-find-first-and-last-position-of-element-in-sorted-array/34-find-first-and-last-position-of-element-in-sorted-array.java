class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] arr = new int[2]; 
        int left = 0;
        int right = nums.length-1;
        int res = -1;
        
        //first occurence
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                res = mid;
                right = mid-1;
            }
            else if(target>nums[mid]){
                left = mid+1;
            }
            else{
               right = mid-1; 
            }
        }
        arr[0] = res;
        //last occurence:
         
         left = 0;
         right = nums.length-1;
         res = -1;
        
        //first occurence
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                res = mid;
                left = mid+1;
            }
            else if(target>nums[mid]){
                left = mid+1;
            }
            else{
               right = mid-1; 
            }
        }
        arr[1] = res;
        return arr;
    }
}