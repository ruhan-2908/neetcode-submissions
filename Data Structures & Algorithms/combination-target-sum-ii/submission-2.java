class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        dfs(nums,target,new ArrayList<>(),0);
        return ans;
    }
    public void dfs(int[] nums, int target, List<Integer> list, int i)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || i >= nums.length) return;
        
        list.add(nums[i]);
        dfs(nums,target-nums[i],list,i);
        list.remove(list.size() - 1);
        dfs(nums,target,list,i+1);
    }
}
