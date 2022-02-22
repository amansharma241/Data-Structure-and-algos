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
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        helper(root,res,new ArrayList<Integer>(),target);
        return res;
    }
    public void helper(TreeNode root,List<List<Integer>> res, List<Integer> temp,int target){
        if(root==null) return;
        temp.add(root.val);
        if(root.left==null && root.right==null && root.val==target){
            res.add(new ArrayList<>(temp)); 
           
        }
        helper(root.left,res,new ArrayList<>(temp),target-root.val);
        helper(root.right,res,new ArrayList<>(temp),target-root.val);
        temp.remove(temp.size()-1);
    }
}