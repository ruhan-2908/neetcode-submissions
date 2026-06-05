class Solution {
    public int swimInWater(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0],0,0});
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty())
        {
            int[] cur = pq.poll();
            int r = cur[1];
            int c = cur[2];
            visited[r][c] = true;
            if(r == ROWS - 1 && c == COLS - 1) return cur[0];
            for(int[] d : dir)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS || visited[nr][nc]) continue;
                pq.offer(new int[]{Math.max(cur[0], grid[nr][nc]),nr,nc});
            }
        }
        return -1;
    }
}
