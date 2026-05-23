class Solution {
    private boolean[] used;
    private int n;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        used = new boolean[n];
        Arrays.sort(nums);
        reverse(nums);
        int total = Arrays.stream(nums).sum();
        int target = total/k;
        return backtrack(0,nums,k,target,0);
    }
    public boolean backtrack(int start , int[] nums, int k, int target, int currentSum)
    {
        if(k == 0) return true;
        if(currentSum == target) return backtrack(0,nums,k-1,target,0);
        
        for(int i = start ; i < nums.length ; i++)
        {
            if(used[i] || currentSum + nums[i] > target) continue;
            used[i] = true;
            if(backtrack(i+1,nums,k,target,currentSum+nums[i]))
            {
                return true;
            }
            used[i] = false;
        }
        return false;
    }
    public void reverse(int[] nums)
    {
        for(int i = 0 ;  i < nums.length / 2 ; i++)
        {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }
}