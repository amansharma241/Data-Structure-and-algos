class Solution {
    public boolean isBipartite(int[][] graph) {
        int [] color = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            
            if(color[i]==-1){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 1;
                
                while(q.size()>0){
                    int node = q.remove();
                    for(int nbr: graph[node]){
                        if(color[nbr]==-1){
                            q.add(nbr);
                            color[nbr] = 1 - color[node];
                        }
                        else if(color[node]==color[nbr]) return false;
                    }
                }
            }
        }
        return true;
    }
}