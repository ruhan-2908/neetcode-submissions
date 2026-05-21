class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<>());
        return ans;
    }
    public void backtrack(int i , int[] nums, List<Integer> list)
    {
        if(i >= nums.length) 
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        backtrack(i+1,nums,list);
        list.remove(list.size() - 1);

        while(i+1<nums.length && nums[i] == nums[i+1]) i++;

        backtrack(i+1,nums,list);
    }
}
