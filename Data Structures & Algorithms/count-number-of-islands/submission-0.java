class Solution {
    boolean[][] visited;
    int n ;
    int m ;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if(grid[i][j]=='1' && visited[i][j] == false)
                {
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
    public void dfs(int i , int j , char[][] grid)
    {
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || visited[i][j])
        {
            return;
        }
        visited[i][j] = true;
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
        return;

    }
}
