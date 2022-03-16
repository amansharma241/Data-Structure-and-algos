class Solution {
    public boolean canFinish(int nums, int[][] pre) {
      ArrayList<Integer> [] adj = new ArrayList[nums];
      int [] visited = new int [nums];
        
        for(int i=0;i<adj.length;i++){
            adj[i] = new ArrayList<>();
        }
        for(int [] curr : pre){
            adj[curr[0]].add(curr[1]);
        }
        for(int i=0;i<nums;i++){
            if(!dfshelper(i,adj,visited)) return false;
        }
        return true;
    }
    public boolean dfshelper(int node , ArrayList<Integer>[] adj,int [] visited){
        if(visited[node]==1) return false;
        if(visited[node]==2) return true;
        
        visited[node] = 1;
        for(int curr : adj[node]){
            if(!dfshelper(curr,adj,visited)) return false;
        }
        visited[node] = 2;
        return true;
    }
}