class Solution {
    public void rotate(int[] nums, int k) {
         k%=nums.length;
        if(nums.length==0) return;
        reverse(0,nums.length-k-1,nums);
        reverse(nums.length-k,nums.length-1,nums);
        reverse(0,nums.length-1,nums);
    }
    public static void reverse(int si,int ei,int [] nums){
        while(si<ei){
            int temp = nums[si];
            nums[si] = nums[ei];
            nums[ei] = temp;
            si++;
            ei--;
        }
    }
}