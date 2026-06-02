class Solution {
    int ROWS;
    int COLS;
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        int ans = 0;
        COLS = grid[0].length;
        for(int r=0;r<ROWS;r++)
        {
            for(int c=0;c<COLS;c++)
            {
                if(grid[r][c] == 1) 
                {
                    ans = Math.max(ans,dfs(r,c,grid));
                }
            }
        }
        return ans;
    }
    public int dfs(int r , int c ,int[][] grid)
    {
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 69 || grid[r][c] == 0) return 0;
        grid[r][c] = 69;
        return 1 + dfs(r+1,c,grid) + dfs(r-1,c,grid) + dfs(r,c+1,grid) + dfs(r,c-1,grid);
    }
}
