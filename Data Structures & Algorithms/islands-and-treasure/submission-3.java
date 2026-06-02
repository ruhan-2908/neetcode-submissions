class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0 ; r < grid.length ; r++)
        {
            for(int c = 0 ; c < grid[0].length ; c++)
            {
                if(grid[r][c] == 0)
                {
                    q.offer(new int[]{r,c});
                }
            }
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            for(int[] d : dir)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != Integer.MAX_VALUE) continue;
                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[]{nr,nc});
            }
        }
    }
}
