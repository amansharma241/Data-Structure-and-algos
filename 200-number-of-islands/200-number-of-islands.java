class Solution {
    public int numIslands(char[][] grid) {
       if(grid==null) return 0;
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    helper(i,j,grid);
                }
            }
        }
        return count;
    }
    public int helper(int i,int j,char [][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0') return 0;
        
        grid[i][j] = '0';
        int up = helper(i-1,j,grid);
        int down = helper(i+1,j,grid);
        int left = helper(i,j-1,grid);
        int right = helper(i,j+1,grid);
        
        return up + down + right + left;
    }
}