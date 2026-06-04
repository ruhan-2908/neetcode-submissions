class Solution {
    public int swimInWater(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[ROWS][COLS];
        pq.offer(new int[]{grid[0][0],0,0});
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();
            int r = curr[1];
            int c = curr[2];
            if(r == ROWS - 1 && c == COLS - 1) return curr[0];
            visited[r][c] = true;
            for(int[] d : dir)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS || visited[nr][nc]) continue;
                pq.offer(new int[]{Math.max(grid[nr][nc],curr[0]),nr,nc});
            }
        }
        return -1;
    }
}
