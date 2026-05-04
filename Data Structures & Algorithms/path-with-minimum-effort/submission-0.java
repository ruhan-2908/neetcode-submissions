class Solution {
    public int minimumEffortPath(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        int[][] dist = new int[ROWS][COLS];
        for(int[] d : dist)
        {
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        dist[0][0] = 0;
        while(!pq.isEmpty())
        {
            int[] temp = pq.poll();
            int diff = temp[0];
            int r = temp[1];
            int c = temp[2];

            if(r == ROWS - 1 && c == COLS - 1) return diff;
            if(diff > dist[r][c]) continue;

            for(int[] dir : directions)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr <0 || nc < 0 || nr >= ROWS || nc >= COLS) continue;
                int newDiff = Math.max(diff,Math.abs(heights[r][c] - heights[nr][nc]));
                if(newDiff < dist[nr][nc])
                {
                    dist[nr][nc] = newDiff;
                    pq.offer(new int[]{newDiff,nr,nc});
                }
            }
        } 
        return 0;  
    }
}