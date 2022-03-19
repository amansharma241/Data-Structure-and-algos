class Solution {
    public int findCircleNum(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph.length;j++){
                if(graph[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        int [] vis = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(vis[i]==0){
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;
    }
    public void dfs(int node,List<List<Integer>> adj,int [] vis){
        vis[node] = 1;
        for(int nbr: adj.get(node)){
            if(vis[nbr]==0){
                dfs(nbr,adj,vis);
            }
        }
    }
}