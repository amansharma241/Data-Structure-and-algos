class Solution {
   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
       Arrays.sort(candidates);
        helper(res,new ArrayList<Integer>(),candidates,target,0);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> ds,int [] arr,int target,int ind){
        if(target< 0) return;
        if(target==0){
            res.add(new ArrayList<>(ds));
        }
        
        for(int i=ind;i<arr.length;i++){
            if(i==ind || arr[i]!=arr[i-1]){
            ds.add(arr[i]);
            helper(res,ds,arr,target-arr[i],i+1);
            ds.remove(ds.size()-1);
            }
        }
    }
}