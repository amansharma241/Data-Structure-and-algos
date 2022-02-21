class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<>();
       helper(candidates,target,0,new ArrayList<>(),res);
        return res;
    }
    public void helper(int [] candidates,int target,int ind, List<Integer> ds,List<List<Integer>> res){
        if(ind==candidates.length){
            if(target==0) res.add(new ArrayList<>(ds));
            return;
        }
        if(candidates[ind]<=target){   // picking elements
            ds.add(candidates[ind]);
            helper(candidates,target-candidates[ind],ind,ds,res);
            ds.remove(ds.size()-1);
        }
        helper(candidates,target,ind+1,ds,res);
    }
}