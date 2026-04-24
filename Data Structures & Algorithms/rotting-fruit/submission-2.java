class Solution {
    int n ;
    int m ;
    public boolean checkanyones(int[][] grid)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1) return true;
            }
        }
        return false;
    }
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 2)
                {
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] direc = {{0,1},{0,-1},{1,0},{-1,0}};
        int res = 0;
        while(!q.isEmpty())
        {
            if(!checkanyones(grid))
            {
                return res;
            }
            res++;
            int size = q.size();
            for(int i = 0 ; i< size ; i++)
            {
                int[] poll = q.poll();
                int row = poll[0];
                int col = poll[1];
                for(int[] dir : direc)
                {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if(r < 0 || c < 0 || r >= n || c >= m || grid[r][c] != 1) continue;
                    grid[r][c] = 2;
                    q.offer(new int[]{r,c});
                }
            }
        }
        if(checkanyones(grid)) return -1;
        return res;
    }
}
