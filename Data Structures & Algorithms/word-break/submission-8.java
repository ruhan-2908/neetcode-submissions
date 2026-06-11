class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int maxLen = 0;
        for(String so : wordDict) 
        {
            if(maxLen < so.length()) maxLen = so.length();
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1 ; i <= n ; i++)
        {
            for(int j = i - 1 ; j >= Math.max(0,i-maxLen) ;  j--)
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
