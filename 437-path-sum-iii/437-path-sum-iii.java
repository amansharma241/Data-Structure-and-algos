/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   // int count=0;
    public int pathSum(TreeNode root, int target) {
        if(root==null) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
       int ans = helper(root,target,0,map);
        return ans;
    }
    public int helper(TreeNode root,int target,int currsum,HashMap<Integer,Integer> map){
        if(root==null) return 0;
        int count=0;
        currsum+=root.val;
        if(map.containsKey(currsum-target)){
            count+=map.get(currsum-target);
        }
        map.put(currsum,map.getOrDefault(currsum,0)+1);
        
        count+=helper(root.left,target,currsum,new HashMap<>(map));
        count+=helper(root.right,target,currsum,new HashMap<>(map));
        return count;
    }
}