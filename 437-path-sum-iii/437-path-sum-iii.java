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
    //int count;
    public int pathSum(TreeNode root, int target) {
        if(root==null) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        //count = 0;
        int currsum = 0;
        return sumhelper(root,target,currsum,map);
    }
    public int sumhelper(TreeNode root,int target,int currsum,HashMap<Integer,Integer> map){
        if(root==null) return 0;
        int count = 0;
        currsum+=root.val;
        if(map.containsKey(currsum-target)){
            count+=map.get(currsum-target);
        }
        map.put(currsum,map.getOrDefault(currsum,0) + 1);
         
        count = count + sumhelper(root.left,target,currsum,map) +sumhelper(root.right,target,currsum,map);
        map.put(currsum, map.get(currsum)-1);
        
        return count;
    }
}