class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        backtrack(nums,target,0,new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] nums, int target, int i, List<Integer> list)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || i == nums.length) return;

        list.add(nums[i]);
        backtrack(nums,target-nums[i],i,list);
        list.remove(list.size() - 1);
        backtrack(nums,target,i+1,list);
    }
}
