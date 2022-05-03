class Solution {
    public int findUnsortedSubarray(int[] nums) {
       if(nums.length==1) return 0;
        int [] dup = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            dup[i] = nums[i];
        }
        Arrays.sort(dup);
        int k=0;
        int j=nums.length-1;
        for(int i=0;i<=nums.length-1;i++){
            if(nums[i]!=dup[i]){
                k = Math.max(i,k);
                j = Math.min(i,j);
            }
        }
        return (k-j>=0 ? k-j+1:0);
    }
}