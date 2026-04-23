class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 0)
                {
                    queue.offer(new int[]{i,j});
                }
            }
        }
        if(queue.isEmpty()) return;
        while(!queue.isEmpty())
        {
            int[] temp = queue.poll();
            int row = temp[0];
            int col = temp[1];
            for(int[] dir : directions)
            {
                int r = row + dir[0];
                int c = col + dir[1];
                if(r<0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != Integer.MAX_VALUE)
                {
                    continue;
                }
                queue.offer(new int[]{r,c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
        return;
    }
}
