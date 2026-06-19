class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];

        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < cols ; j++)
            {
                if(i==0 && j==0) continue;
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j] = grid[i][j] + Math.min(up,left);
            }
        }
        return dp[rows-1][cols-1];
    }
}