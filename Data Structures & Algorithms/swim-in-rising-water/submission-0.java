class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0],0,0});
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty())
        {
            int[] temp = pq.poll();
            int r = temp[1];
            int c = temp[2];

            if(visited[r][c]) continue;
            if(r == n-1 && c == m - 1) return temp[0];

            visited[r][c] = true;

            for(int[] d : directions)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr >=0 && nc >=0 && nr < n && nc < m && !visited[nr][nc])
                {
                    pq.offer(new int[]{Math.max(temp[0],grid[nr][nc]),nr,nc});
                }
            }
        }
        return -1;
    }
}
