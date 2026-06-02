class Solution {
    int ROWS;
    int COLS;
    int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        for(int c = 0 ; c < COLS ; c++)
        {
            fill(0,c,pacific,heights);
            fill(ROWS-1,c,atlantic,heights);
        }

        for(int r = 0 ; r < ROWS ; r++)
        {
            fill(r,0,pacific,heights);
            fill(r,COLS-1,atlantic,heights);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int r = 0 ; r < ROWS ; r++)
        {
            for(int c = 0 ; c < COLS ; c++)
            {
                if(pacific[r][c] && atlantic[r][c]) ans.add(new ArrayList<>(Arrays.asList(r,c)));
            }
        }
        return ans;
    }
    public void fill(int r ,int c , boolean[][] ocean , int[][] heights)
    {
        if(ocean[r][c]) return;
        ocean[r][c] = true;
        for(int[] d : dir)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS) continue;
            if(heights[nr][nc] >= heights[r][c]) fill(nr,nc,ocean,heights); 
        } 
        return;
    }
}
