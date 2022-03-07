class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums==null) return 0;
        int [] len = new int[nums.length];
        int [] count = new int[nums.length];
        Arrays.fill(len,1);
        Arrays.fill(count,1);
        int maxlen = 0;
        int res = 0;
        for(int i=0;i<len.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(len[j] + 1 > len[i]){
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                    else if(len[j] + 1 == len[i]) count[i] += count[j];
                }
            }
            if(maxlen==len[i]) res += count[i];
            if(maxlen<len[i]){
                maxlen = len[i];
                res = count[i];
            }
        }
        return res;
    }
}