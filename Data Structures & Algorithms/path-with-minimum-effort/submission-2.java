class Solution {
    public int minimumEffortPath(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        int[][] dp = new int[ROWS][COLS];
        for(int[] d : dp) Arrays.fill(d,Integer.MAX_VALUE);
        dp[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0,0,0});
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty())
        {
            int[] temp = pq.poll();
            int r = temp[1];
            int c = temp[2];
            if(r == ROWS - 1 && c == COLS - 1) return temp[0];
            if(temp[0] > dp[r][c]) continue;
            for(int[] d : dir)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr <0 || nc < 0 || nr >= ROWS || nc >= COLS) continue;
                int newDiff = Math.max(temp[0],Math.abs(heights[r][c] - heights[nr][nc]));
                if(newDiff < dp[nr][nc])
                {
                    dp[nr][nc] = newDiff;
                    pq.offer(new int[]{newDiff,nr,nc});
                }
            }
        }
        return 0;
    }
}