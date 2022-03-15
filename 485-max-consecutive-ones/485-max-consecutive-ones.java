class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums==null) return 0;
        int count = 0;
        int maxi = 0;
        for(int num: nums){
            if(num==0) count = 0;
            else count++;
            
            maxi = Math.max(count,maxi);
        }
        return maxi;
    }
}