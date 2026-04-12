class Solution {
    private boolean[] used;
    private int n;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        n = nums.length;
        used = new boolean[n];
        for(int i = 0 ; i < n/2 ;i++)
        {
            int temp = nums[i];
            nums[i] = nums[n -i-1];
            nums[n-i-1] = temp;
        }
        int target = Arrays.stream(nums).sum()/k;
        return backtrack(0,k,nums,0,target);
    }
    private boolean backtrack(int start , int k ,int[] nums,int currentSum,int target)
    {
        if(k == 0) return true;
        if(currentSum == target) return backtrack(0,k-1,nums,0,target);

        for(int i = start ; i < n ; i++)
        {
            if(used[i] || currentSum + nums[i] > target) continue;
            used[i] = true;
            if(backtrack(i+1,k,nums,currentSum+nums[i],target))
            {   
                return true;
            }
            used[i] = false;
        }
        return false;
    } 
}