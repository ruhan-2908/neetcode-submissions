class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];
        for(int r = 0 ; r < m ; r++)
        {
            dp[r][0] = 0;
        }

        for(int c = 0 ; c < n ; c++)
        {
            dp[0][c] = 0;
        }

        for(int r = 1 ; r < m+1 ; r++)
        {
            for(int c = 1 ; c < n+1 ; c++)
            {
                if(text1.charAt(r-1) == text2.charAt(c-1))
                {
                    dp[r][c] = 1 + dp[r-1][c-1];
                }else
                {
                    dp[r][c] = Math.max(dp[r-1][c],dp[r][c-1]);
                }
            }
        }

        return dp[m][n];
    }
}
