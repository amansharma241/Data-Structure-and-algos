// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        // initiate everything
        int steps = 0;
        int [][] vis = new int [N+1][N+1];
        Queue<int []> q = new LinkedList<>();
        int [][] dirs = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
        // insert into queue
        q.add(KnightPos);
        // bfs traversal
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int [] front = q.poll();
                if(front[0]==TargetPos[0] && front[1]==TargetPos[1]) return steps;
                int x = front[0];
                int y = front[1];
                vis[x][y] = 1;
                for(int [] dir: dirs){
                    int xdash = x + dir[0];
                    int ydash = y + dir[1];
                    if(xdash>0 && xdash<=N && ydash>0 && ydash<=N&& vis[xdash][ydash]==0){
                        int [] ncoord = {xdash,ydash};
                        q.add(ncoord);
                        vis[xdash][ydash]=1;
                    }
                }
            }
            steps++;
        }
        
        if(steps>0) return steps;
        return -1;
    }
}