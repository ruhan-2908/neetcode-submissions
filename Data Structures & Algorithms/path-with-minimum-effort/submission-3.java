class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        q.offer(new int[]{0,0,0});
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] dp = new int[rows][cols];
        for(int[] r : dp) Arrays.fill(r,Integer.MAX_VALUE);
        dp[0][0] = 0;
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            int row = curr[1];
            int col = curr[2];
            if(row == rows - 1 && col == cols - 1) return curr[0];
            if(dp[row][col] < curr[0]) continue;

            for(int[] d : dir)
            {
                int nr = row + d[0];
                int nc = col + d[1];
                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols)continue;
                int newDiff = Math.max(Math.abs(heights[nr][nc] - heights[row][col]),curr[0]);
                if(newDiff < dp[nr][nc])
                {
                    dp[nr][nc] = newDiff;
                    q.offer(new int[]{newDiff,nr,nc});
                }
            }
        }
        return -1;
    }
}