class Solution {
    int[][] dp;
    int m;
    int n;
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();
        dp = new int[m+1][n+1];
        for(int[] d : dp) Arrays.fill(d,-1);

        return dfs(s,t,0,0);
    }
    public int dfs(String s, String t , int i , int j)
    {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int res = dfs(s,t,i+1,j);
        if(s.charAt(i) == t.charAt(j))
        {
            res += dfs(s,t,i+1,j+1);
        }

        dp[i][j] = res;
        return res;
    }
}
