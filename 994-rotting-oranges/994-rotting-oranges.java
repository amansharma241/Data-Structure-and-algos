class Solution {
   
    public int orangesRotting(int[][] grid) {
      int fresh = 0;
      int minutes = 0;
      Queue<int []> queue = new LinkedList<>();
      for(int i = 0;i<grid.length;i++){
          for(int j = 0;j<grid[0].length;j++){
              if(grid[i][j]==2) queue.offer(new int[]{i,j});
              else if(grid[i][j]==1) fresh++;
          }
      }
        if(fresh==0) return 0;
        int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
         while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size(); //Rotten oranges simultaneously affect adjacent fresh oranges.
            for(int i = 0; i < size; i++) {
                //if using queue.size() instead of size, it will be not working properly, beacuse queue is changeable.
                int[] now = queue.poll();
                for (int[] dir : dirs) { //find fresh oragnes from adjacent directions.
                    int x = now[0] + dir[0];
                    int y = now[1] + dir[1];

                    if (x > grid.length - 1 || x < 0 || y > grid[0].length - 1 || y < 0) continue;
                    if (grid[x][y] == 1) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2; //rotten..!!
                        fresh--;
                    }
                }
            }
        }
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     minutes++;
        //     while(size>0){
        //         int [] arr = q.poll();
        //         //System.out.print(arr[1]);
        //         for(int dir []  : dirs){
        //            int rdash = arr[0] + dir[0];
        //            int cdash = arr[1] + dir[1];
        //             if(rdash<0 || rdash>=grid.length || cdash<0 || cdash>=grid[0].length || grid[rdash][cdash]==2 || grid[rdash][cdash]==0){
        //                continue; 
        //             }
        //             q.offer(new int[]{rdash,cdash});
        //             grid[rdash][cdash] = 2;
        //             fresh--;
        //         }
        //     }
        // }
        if(fresh==0) return minutes-1;
        else return -1;
    }
}