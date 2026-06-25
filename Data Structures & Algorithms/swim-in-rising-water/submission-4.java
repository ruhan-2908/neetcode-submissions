class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{grid[0][0],0,0});
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[rows][cols];
        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();
            int row = curr[1];
            int col = curr[2];
            int wei = curr[0];
            if(row == rows - 1 && col == cols - 1) return wei;
            visited[row][col] = true;

            for(int[] d : dir)
            {
                int nr = row + d[0];
                int nc = col + d[1];
                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols || visited[nr][nc]) continue;
                pq.offer(new int[]{Math.max(grid[nr][nc],wei),nr,nc});
            }
        }


        return -1;
    }
}
