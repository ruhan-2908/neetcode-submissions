class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    int ROWS;
    int COLS;
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int r=0;r<grid.length;r++)
        {
            for(int c=0;c<grid[0].length ; c++)
            {
                if(grid[r][c] == 0) 
                {
                    q.offer(new int[]{r,c});
                }
            }
        }
        while(!q.isEmpty())
        {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            for(int[] d : dir)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS || grid[nr][nc] != Integer.MAX_VALUE) continue;
                q.offer(new int[]{nr,nc});
                grid[nr][nc] = grid[r][c] + 1;
            }
        }
        return;
    }
}
