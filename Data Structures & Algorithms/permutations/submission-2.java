class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums,0);
        return ans;
    }
    public void dfs(int[] nums, int idx)
    {
        if(idx >= nums.length)
        {
            List<Integer> curr = new ArrayList<>();
            for(int e : nums) curr.add(e);
            ans.add(curr);
            return;
        }
        for(int i = idx ; i < nums.length ; i++)
        {
            swap(nums,i,idx);
            dfs(nums,idx+1);
            swap(nums,i,idx);
        }
    }
    public void swap(int[] nums, int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
