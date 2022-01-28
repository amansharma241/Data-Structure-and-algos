class Solution {
    public int log2(int p){
        return (int)(Math.log(p)/Math.log(2));
    }
    public List<List<Integer>> subsets(int[] nums) {
        //Arrays.sort(nums);
        List<List<Integer>> powerset = new ArrayList<>();
        int size=(int)Math.pow(2,nums.length);
        for(int i=0;i<size;i++){
            int num=i;
            List<Integer> set = new ArrayList<>();
            while(num>0){
                int index=log2(num&(-num));
                set.add(nums[index]);
                num=num&(num-1);
            }
            powerset.add(set);
        }
        return powerset;
    }
}