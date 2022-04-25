class Solution {
    public int largestIsland(int[][] grid) {
        if(grid==null) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int island_id = 2;
        int max = 0;
        int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int size = getislandsize(i,j,grid,island_id);
                    max = Math.max(size,max);
                    map.put(island_id++,size);
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> set = new HashSet<>();
                    for(int [] dir : dirs){
                        int xdash = i + dir[0];
                        int ydash = j + dir[1];
                        if(xdash>-1 && xdash<grid.length && ydash<grid[0].length && ydash>-1 && grid[xdash][ydash]!=0){ 
                                set.add(grid[xdash][ydash]);
                    }
                    }
                    int sum = 1;
                    for(int num : set){
                        sum+=map.get(num);
                    }
                    max = Math.max(max,sum);
                }
            }
        }
        return max;
    }
    public int getislandsize(int i,int j,int [][] grid,int island_id){
        if(i<0 || i>=grid.length || j>=grid[0].length || j<0 || grid[i][j]!=1) return 0;
        grid[i][j] = island_id;
        int up = getislandsize(i-1,j,grid,island_id);
        int down = getislandsize(i+1,j,grid,island_id);
        int right = getislandsize(i,j+1,grid,island_id);
        int left = getislandsize(i,j-1,grid,island_id);
        return 1 + up + down + right + left;
    }
}