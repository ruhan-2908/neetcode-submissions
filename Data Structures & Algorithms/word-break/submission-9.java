class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int maxLen = 0;
        for(String str : wordDict)
        {
            if(str.length() > maxLen) maxLen = str.length();
            set.add(str);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1 ; i <= s.length() ; i++)
        {
            for(int j = i - 1 ; j >= Math.max(j - maxLen,0)  ; j--)
            {
                if(dp[j] && set.contains(s.substring(j,i))) 
                {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
