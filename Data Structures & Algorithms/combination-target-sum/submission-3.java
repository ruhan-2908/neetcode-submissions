class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        backtrack(nums,target,0, new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] nums, int target, int i, List<Integer> curList)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(curList));
            return;
        }
        if(target < 0 || i >= nums.length) return;
        curList.add(nums[i]);
        backtrack(nums,target-nums[i],i,curList);
        curList.remove(curList.size() - 1);
        backtrack(nums,target,i+1,curList)
        ;
    }
}
