class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums,target,0,0);
        return ans;
    }

    public void backtrack(int[] nums, int target , int i, int currSum)
    {
        if(currSum == target && i == nums.length)
        {
            ans++;
            return;
        }
        if(i == nums.length)
        {
            return;
        }

        backtrack(nums,target,i+1,currSum + nums[i]);
        backtrack(nums,target,i+1,currSum - nums[i]);
    }
}
