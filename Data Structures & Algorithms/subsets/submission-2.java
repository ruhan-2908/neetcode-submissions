class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        dfs(0,nums,new ArrayList<>());
        return ans;
    }
    public void dfs(int i , int[] nums, List<Integer> list)
    {
        ans.add(new ArrayList<>(list));
        for(int j = i ; j < nums.length ; j++)
        {
            list.add(nums[j]);
            dfs(j+1,nums,list);
            list.remove(list.size() - 1);
        }
    }
}
