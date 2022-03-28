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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(0,preorder.length-1,preorder,0,inorder.length-1,inorder,map);
    }
    public TreeNode helper(int prestart,int preend,int [] preorder,int instart,int inend,int []          inorder,HashMap<Integer,Integer> map){
        if(prestart>preend || instart>inend) return null;
        
        TreeNode root = new TreeNode(preorder[prestart]);
        int inIndex = map.get(root.val);
        
        root.left = helper(prestart+1,prestart + inIndex-instart,preorder,instart,inIndex-1,inorder,map);
        root.right = helper(prestart + inIndex-instart+1,preend,preorder,inIndex+1,inend,inorder,map);
        
        return root;
    }
}