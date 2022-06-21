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
       List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        helper(new ArrayList<Integer>(),root,list,target);
        return list;
    }
    public void helper(List<Integer> sublist,TreeNode root,List<List<Integer>> list,int target){
        if(root==null) return;
        sublist.add(root.val);
        if(root.left==null && root.right==null && target==root.val){
            list.add(new ArrayList<>(sublist));
           // return;
        }
        helper(sublist,root.left,list,target-root.val);
        helper(sublist,root.right,list,target-root.val);
        sublist.remove(sublist.size()-1);
    }
}