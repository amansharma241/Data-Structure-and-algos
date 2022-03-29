class Solution {
    public int findDuplicate(int[] nums) {
        if(nums==null) return 0;
        int duplicate = -1;
        for(int i=0;i<nums.length;i++){
            int ind = Math.abs(nums[i]);
            if(nums[ind]<0){
                duplicate = ind;
                break;
            }
            nums[ind] *= -1;
        }
        return duplicate;
    }
}