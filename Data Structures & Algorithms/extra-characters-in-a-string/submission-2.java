class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> home = new HashSet<>();
        for(String str : dictionary)
        {
            home.add(str);
        }
        int[] dp = new int[s.length()+1];
        for(int i = s.length()-1;i>=0;i--)
        {
            dp[i] = 1 + dp[i+1];
            for(int j = i ; j < s.length() ; j++)
            {
                if(home.contains(s.substring(i,j+1)))
                {
                    dp[i] = Math.min(dp[i],dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}