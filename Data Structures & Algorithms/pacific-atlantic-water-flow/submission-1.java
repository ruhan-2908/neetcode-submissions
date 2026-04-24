class Solution {
    int n;
    int m;
    List<List<Integer>> ans;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ans = new ArrayList<>();
        n = heights.length;
        m = heights[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];
        for(int c = 0 ; c < m ; c++)
        {
            dfs(0,c,pac,heights);
            dfs(n-1,c,atl,heights);
        }

        for(int r = 0 ; r < n ; r++)
        {
            dfs(r,0,pac,heights);
            dfs(r,m-1,atl,heights);
        }

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if(pac[i][j] && atl[i][j]) ans.add(new ArrayList<>(List.of(i,j)));
            }
        }
        return ans;
    }
    public void dfs(int r, int c, boolean[][] ocean , int[][] heights)
    {
        ocean[r][c] = true;
        for(int[] d : dir)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nc >=0 && nr < n && nc < m && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c])
            {
                dfs(nr,nc,ocean,heights);
            }
        }
    }
}
