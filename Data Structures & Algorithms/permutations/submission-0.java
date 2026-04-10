class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        backtrack(0,nums);
        return list;
    }
    private void backtrack(int idx, int[] nums)
    {
        if(idx >= nums.length)
        {
            List<Integer> curList = new ArrayList
            <>();
            for(int el : nums) curList.add(el);
            list.add(curList);
            return;
        }

        for(int i = idx ; i < nums.length ; i++)
        {
            swap(nums,i,idx);
            backtrack(idx+1,nums);
            swap(nums,i,idx);
        }
    }
    private void swap(int[] nums , int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
