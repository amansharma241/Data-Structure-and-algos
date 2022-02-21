class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<Integer>(),candidates,target,0);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> ds,int [] arr,int target,int ind){
        if(target< 0) return;
        if(target==0){
            res.add(new ArrayList<>(ds));
        }
        
        for(int i=ind;i<arr.length;i++){
            ds.add(arr[i]);
            helper(res,ds,arr,target-arr[i],i);
            ds.remove(ds.size()-1);
        }
    }
}