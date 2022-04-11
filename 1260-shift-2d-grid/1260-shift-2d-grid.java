class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k %= m * n;
        reverse(grid, 0, m * n - 1);
        reverse(grid, 0, k - 1);
        reverse(grid, k, m * n - 1);
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] row : grid)
            ans.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
        return ans;
    }
    private void reverse(int[][] g, int lo, int hi) {
        int m = g.length, n = g[0].length;
        while (lo < hi) {
            int r = lo / n, c = lo++ % n, i = hi / n, j = hi-- % n, 
            tmp = g[r][c];
            g[r][c] = g[i][j];
            g[i][j] = tmp;
        }
    }
}