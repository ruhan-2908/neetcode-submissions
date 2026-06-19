class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for(int l = n - 1 ; l >= 0 ; l--)
        {
            for(int r = l ; r < n ; r++)
            {
                boolean even = (r-l) % 2 == 0;
                int left = even ? piles[l] : 0;
                int right = even ? piles[r] : 0;

                if(l == r)
                {
                    dp[l][r] = piles[l];
                }else
                {
                    dp[l][r] = Math.max(dp[l+1][r] + left, dp[l][r-1] + right);
                }
            }
        }

        int total = 0;
        for(int p : piles) total += p;

        return dp[0][n-1] > total - dp[0][n-1];
    }
}