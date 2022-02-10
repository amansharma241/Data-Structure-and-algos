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
// public class Tuple{
//     TreeNode node;
//     int level;
    
//     Tuple(TreeNode node,int level){
//         this.node = node;
//         this.level = level;
//     }
// }
// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         Queue<Tuple> q = new LinkedList<>();
//         HashMap<Integer,List<Integer>> map = new HashMap<>();
//         int lmax=0;
//         int lmin=0;
        
//         q.add(new Tuple(root,0));
//         while(!q.isEmpty()){
//             int n = q.size();
            
//             for(int i=0;i<n;i++){
//                 Tuple t = q.poll();
//                 List<Integer> nodeList = map.getOrDefault(t.level, new ArrayList<>());
//                 nodeList.add(t.node.val);
//                 Collections.sort(nodeList);
//                 map.put(t.level, new ArrayList<>(nodeList));
                
//                 lmax = Math.max(lmax,t.level);
//                 lmin = Math.min(lmin,t.level);
                
//                 if(t.node.left!=null) q.add(new Tuple(t.node.left,t.level-1));
//                 if(t.node.right!=null) q.add(new Tuple(t.node.right,t.level+1));
                
//             }
//         }
//         for(int i=lmin;i<=lmax;i++){
//             result.add(map.get(i));
//         }
//         return result;
//     }
// }

class NodeDistance {
    
    int dist;
    TreeNode node;
    NodeDistance(int dist, TreeNode node) {
        this.dist = dist;
        this.node = node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        if(root == null) {
            return new ArrayList<>();
        }
        
        TreeMap<Integer, List<Integer>>  distanceMap = new TreeMap<>();
        Queue<NodeDistance> q = new LinkedList<>();
        q.add(new NodeDistance(0, root));
        
        //Level order traversal
        while(!q.isEmpty()) {
            
            int size = q.size();
            HashMap<Integer, List<Integer>> levelMap = new HashMap<>();
            while(size-- > 0) {
                
                NodeDistance current = q.poll();
                int distance = current.dist;
                List<Integer> nodeList = levelMap.getOrDefault(distance, new ArrayList<>());
                nodeList.add(current.node.val);
                Collections.sort(nodeList);
                levelMap.put(distance, new ArrayList<>(nodeList));
                
                if(current.node.left != null) {
                    q.add(new NodeDistance(distance-1, current.node.left));
                }
                
                 if(current.node.right != null) {
                    q.add(new NodeDistance(distance+1, current.node.right));
                }
                
            }
			
            //Update the distanceMap with levelMap values
            for(Map.Entry<Integer,List<Integer>> entry : levelMap.entrySet()) {
                
                List<Integer> nodeList = distanceMap.getOrDefault(entry.getKey(), new ArrayList<>());
                nodeList.addAll(entry.getValue());
                distanceMap.put(entry.getKey(), nodeList);
                
            }
        }
        
        return new ArrayList<>(distanceMap.values());
        
    }
}