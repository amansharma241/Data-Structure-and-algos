class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int oneCnt = 0, zeroCnt = 0;
        int ret = 0;
        for (int i = 0; i < 30; i++) {
            oneCnt = 0;
            for (int j = 0; j < nums.length; j++) {
                oneCnt += (nums[j] >> i) & 1;
            }
            zeroCnt = n - oneCnt;
            ret += oneCnt * zeroCnt;
        }
        return ret;
    }
}