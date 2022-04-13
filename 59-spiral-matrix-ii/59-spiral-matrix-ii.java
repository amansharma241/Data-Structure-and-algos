class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        
        
        int count = 1;
        
        for(int i=0;i<=n/2;i++)
        {
            
            for(int c = i;c<n-i-1;c++)
            {
                m[i][c] = count++;
            }
            
            for(int r=i;r<n-i-1;r++)
            {
                m[r][n-i-1] = count++;
            }
            
            for(int c = n-i-1;c>i;c--)
            {
                m[n-i-1][c] = count++;
            }
            
            for(int r = n-i-1;r>i;r--)
            {
                m[r][i] = count++;
            }
        }
        
        if(n%2 == 1)
        {
            m[n/2][n/2] = count++;
        }
        
        return m; 
    }
}