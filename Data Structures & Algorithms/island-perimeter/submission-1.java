class Solution {
    int ROWS;
    int COLS;
    public int islandPerimeter(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == 1) return dfs(i,j,grid);
            }
        }
        return -1;
    }
    public int dfs(int r , int c,int[][] grid)
    {
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0) return 1;
        if(grid[r][c] == -1) return 0;
        grid[r][c] = -1;
        int top = dfs(r-1,c,grid);
        int left = dfs(r,c-1,grid);
        int right = dfs(r,c+1,grid);
        int bottom = dfs(r+1,c,grid);
        return top + left + right + bottom;
    }
}