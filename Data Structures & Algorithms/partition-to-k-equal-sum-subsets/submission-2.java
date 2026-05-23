class Solution {
    boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = Arrays.stream(nums).sum();
        visited = new boolean[nums.length];
        if(total % k != 0) return false;
        int target = total / k;
        Arrays.sort(nums);
        reverse(nums);
        return backtrack(nums,0,0,target,k);
    }
    public boolean backtrack(int[] nums, int idx, int currSum , int target, int k)
    {
        if(k==0) return true;
        if(currSum == target) return backtrack(nums,0,0,target,k-1);

        for(int i = idx ; i < nums.length ; i++)
        {
            if(visited[i] || currSum + nums[i] > target) continue;
            visited[i] = true;
            if(backtrack(nums,i+1,currSum+nums[i],target,k)) return true;
            visited[i] = false;
        }
        return false;
    }
    public void reverse(int[] nums)
    {
        for(int i = 0 ;  i < nums.length ; i++)
        {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }
}