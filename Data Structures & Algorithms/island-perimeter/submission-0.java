class Solution {
    private int ROWS;
    private int COLS;
    private int[][] grid;
    private boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        this.grid = grid;
        visited = new boolean[ROWS][COLS];
        for(int i = 0 ; i < ROWS ; i++)
        {
            for(int j = 0 ; j < COLS ; j++)
            {
                if(grid[i][j] == 1) return dfs(i,j);
            }
        }
        return 0;
    }
    public int dfs(int r , int c)
    {
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0) return 1;
        if(visited[r][c]) return 0;
        visited[r][c] = true;
        return dfs(r+1,c) + dfs(r-1,c) + dfs(r,c+1) + dfs(r,c-1);
    }
}