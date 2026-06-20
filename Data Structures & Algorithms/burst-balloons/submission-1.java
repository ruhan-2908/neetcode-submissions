class Solution {
    public int maxCoins(int[] nums) {
        int[] home = new int[nums.length + 2];
        home[0] = home[nums.length + 1] = 1;
        for(int i = 1 ; i <= nums.length ; i++) home[i] = nums[i-1];
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for(int[] layer : dp) Arrays.fill(layer,-1);
        return dfs(home,1,nums.length,dp);
    }
    public int dfs(int[] nums, int l , int r,int[][] dp)
    {
        if(l > r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        dp[l][r] = 0;
        for(int i = l ; i <= r ; i++)
        {
            int coins = nums[l-1] * nums[i] * nums[r+1];
            coins += dfs(nums,l,i-1,dp) + dfs(nums,i+1,r,dp);
            dp[l][r] = Math.max(dp[l][r],coins);
        }

        return dp[l][r];
    }
}
