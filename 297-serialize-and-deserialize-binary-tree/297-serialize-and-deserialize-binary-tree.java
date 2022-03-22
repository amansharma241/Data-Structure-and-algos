/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//        if(root==null) return "";
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         StringBuilder res = new StringBuilder();
//         while(q.size()>0){
//             TreeNode temp = q.poll();
//             if(temp==null){
//                 res.append("n ");
//                 continue;
//             }
//             res.append(temp.val + " ");
//             q.add(root.left);
//             q.add(root.right);
//         }
//         return res.toString();
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         String [] arr = data.split(" ");
//         TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         for(int i=1;i<arr.length;i++){
//             TreeNode parent = q.poll();
//             if(!arr[i].equals("n")){
//                 TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
//                 parent.left = left;
//                 q.add(left);
//             }
//             if(!arr[++i].equals("n")){
//                 TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
//                 parent.right = right;
//                 q.add(right);
//             }
//         }
//         return root;
//     }
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    
    private TreeNode helper(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));