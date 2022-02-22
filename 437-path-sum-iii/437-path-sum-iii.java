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
    int count=0;
    public int pathSum(TreeNode root, int target) {
        if(root==null) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        helper(root,target,0,map);
        return count;
    }
    public void helper(TreeNode root,int target,int currsum,HashMap<Integer,Integer> map){
        if(root==null) return;
        
        currsum+=root.val;
        if(map.containsKey(currsum-target)){
            count+=map.get(currsum-target);
        }
        map.put(currsum,map.getOrDefault(currsum,0)+1);
        
        helper(root.left,target,currsum,new HashMap<>(map));
        helper(root.right,target,currsum,new HashMap<>(map));
    }
}