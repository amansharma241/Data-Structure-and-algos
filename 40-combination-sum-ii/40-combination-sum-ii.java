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
            if(i==ind || arr[i]!=arr[i-1]){ // thik hai agar ind pe hai kyoki ind se hi call start kari hai
                                            // agar pichla wala element same hua to koi matlab nhi hua phir                                             //kaam krne ka
            ds.add(arr[i]);
            helper(res,ds,arr,target-arr[i],i+1); // picking element
            ds.remove(ds.size()-1);       // wapas aate hue element uda diya , mtlb ab not picking wale                                               //recursion ke raste pe jayenge
            }
        }
    }
}