class Solution {
    Boolean[][] dp;
    int m;
    int n;
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();

        dp = new Boolean[m+1][n+1];

        return dfs(0,0,s,p);
    }

    public boolean dfs(int i , int j , String s , String p)
    {
        if(j == n) return i == m;

        if(dp[i][j] != null) return dp[i][j];


        boolean match = (i < m) && ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.'));


        if(j+1 < n && p.charAt(j+1) == '*')
        {
            dp[i][j] = dfs(i,j+2,s,p) || (match && dfs(i+1,j,s,p));
        }else
        {
            dp[i][j] = match && dfs(i+1,j+1,s,p);
        }

        return dp[i][j];
    }
}
