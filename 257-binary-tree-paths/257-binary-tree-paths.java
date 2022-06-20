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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if(root==null) return list;
        String path = "";
        helper(root,path,list);
        return list;
    }
    public void helper(TreeNode root,String path,ArrayList<String> list){
        if(root==null) return;
        path+=root.val;
        if(root.left==null && root.right==null){
            list.add(path);
            return;
        }
        helper(root.left,path + "->",list);
        helper(root.right,path + "->",list);
        //path-=root.val;
    }
}