class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] ans = new int[nums.length];
        if(nums.length==0) return ans;
        
        int prod = 1;
        for(int i=0;i<nums.length;i++){
            ans[i]=prod;
            prod*=nums[i];
        }
         prod = 1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i] *= prod;
            prod*=nums[i];
        }
        return ans;
    }
}


// int[] result = new int[nums.length];
//     for (int i = 0, tmp = 1; i < nums.length; i++) {
//         result[i] = tmp;
//         tmp *= nums[i];
//     }
//     for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
//         result[i] *= tmp;
//         tmp *= nums[i];
//     }
//     return result;