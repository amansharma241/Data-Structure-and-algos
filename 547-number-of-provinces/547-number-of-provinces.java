class Solution {
    public int findCircleNum(int[][] graph) {
        // List<List<Integer>> adj = new ArrayList<>();
        // for(int i=0;i<graph.length;i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int i=0;i<graph.length;i++){
        //     for(int j=0;j<graph.length;j++){
        //         if(graph[i][j]==1){
        //             adj.get(i).add(j);
        //             adj.get(j).add(i);
        //         }
        //     }
        // }
        int count = 0;
        int [] vis = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(vis[i]==0){
                count++;
                dfs(i,graph,vis);
            }
        }
        return count;
    }
    public void dfs(int node,int [][] graph,int [] vis){
        vis[node] = 1;
        for(int j=0;j<graph.length;j++){
            if(graph[node][j]==1 && vis[j]==0){
                dfs(j,graph,vis);
            }
        }
    }
}