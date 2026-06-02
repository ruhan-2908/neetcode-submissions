class Solution {
    int components = 0;
    int ROWS;
    int COLS;
    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        for(int  i = 0 ; i < ROWS ; i++)
        {
            for(int j = 0 ; j < COLS ; j++)
            {
                if(grid[i][j] == '1') 
                {
                    dfs(i,j,grid);
                    components++;
                }
            }
        }
        return components;
    }
    public void dfs(int r , int c , char[][] grid)
    {
        if( r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == '#' || grid[r][c] == '0') return;
        grid[r][c] = '#';
        dfs(r-1,c,grid);
        dfs(r+1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
        return;
    }
}
