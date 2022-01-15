class Solution {
    public boolean search(int[] nums, int target) {
         int l = 0, h = nums.length-1;
    while(l <= h){
        int mid = l + (h-l)/2;
        if(nums[mid] == target)     return true;
        if(nums[mid] == nums[h])    h--;
        else if(nums[mid] < nums[h]){
            if(target > nums[mid] && target <= nums[h])
                l = mid + 1;
            else
                h = mid - 1;
        }else{
            if(target >= nums[l] && target < nums[mid])
                h = mid - 1;
            else
                l = mid + 1;
        }
    }
    return false; 
    }
}