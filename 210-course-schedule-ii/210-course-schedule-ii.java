class Solution {
    public int[] findOrder(int nums, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int [] visited = new int[nums];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<nums;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] curr : pre){
            adj.get(curr[0]).add(curr[1]);
        }
        for(int i=0;i<nums;i++){
            if(!dfshelper(i,adj,visited,st)){
                return new int[0];
            }
        }
        int [] result = new int[nums];
        int ind = result.length-1;
        while(!st.isEmpty()){
            result[ind--] = st.pop();
        }
        return result;
    }
    public boolean dfshelper(int node,ArrayList<ArrayList<Integer>> adj,int [] visited,Stack<Integer> st){
        if(visited[node]==1) return false;
        if(visited[node]==2) return true;
        visited[node] = 1;
        
        for(int nbr: adj.get(node)){
            if(!dfshelper(nbr,adj,visited,st)) return false;
        }
        visited[node]=2;
        st.push(node);
        return true;
    }
}