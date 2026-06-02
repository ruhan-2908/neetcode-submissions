class Solution {
    int ROWS;
    int COLS;
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0 ; r < ROWS ; r++)
        {
            for(int c = 0 ; c < COLS ; c++)
            {
                if(grid[r][c] == 2)
                {
                    q.offer(new int[]{r,c});
                }
            }
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int minutes = 0;
        while(!q.isEmpty())
        {
            if(checkZeroes(grid)) return minutes;    
            minutes++;
            int length = q.size();
            for(int i = 0 ; i < length ; i++)
            {
                int[] temp = q.poll();
                int row = temp[0];
                int col = temp[1];
                for(int[] d : dir)
                {
                    int nr = row + d[0];
                    int nc = col + d[1];
                    if(nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS || grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        if(checkZeroes(grid)) return minutes;
        return -1;
    }
    public boolean checkZeroes(int[][] grid)
    {
        for(int r = 0 ; r < ROWS ; r++)
        {
            for(int c = 0 ; c < COLS ; c++)
            {
                if(grid[r][c] == 1) return false;
            }
        }
        return true;
    }
}
