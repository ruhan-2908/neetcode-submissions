class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> permuteUnique(int[] nums) {
        list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums);
        return list;
    }
    private void backtrack(int i , int[] nums)
    {
        if(i==nums.length)
        {
            List<Integer> curList = new ArrayList<>();
            for(int el : nums) curList.add(el);
            list.add(new ArrayList<>(curList));
            return;
        }
        for(int j=i;j<nums.length ;j++)
        {
            if(j>i && nums[j] == nums[i]) continue;
            swap(nums,i,j);
            backtrack(i+1,nums);
        }
        for(int j = nums.length-1 ; j > i ; j--)
        {
            swap(nums,i,j);
        }
    }
    private void swap(int[] nums,int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}