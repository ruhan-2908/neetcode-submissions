class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        backtrack(0,nums);
        return ans;
    }
    public void backtrack(int idx , int[] nums)
    {
        if(idx>=nums.length)
        {
            List<Integer> curr = new ArrayList<>();
            for(int n : nums) curr.add(n);
            ans.add(curr);
        }
        for(int i = idx ; i < nums.length ; i++)
        {
            swap(nums,i,idx);
            backtrack(idx+1,nums);
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
