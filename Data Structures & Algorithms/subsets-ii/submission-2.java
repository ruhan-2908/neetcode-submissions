class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,new ArrayList<>(),0);
        return ans;
    }
    public void dfs(int[] nums, List<Integer> list, int i)
    {
        if(i >= nums.length) 
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[i]);
        dfs(nums,list,i+1);
        list.remove(list.size() - 1);

        while(i+1<nums.length && nums[i] == nums[i+1]) i++;

        dfs(nums,list,i+1);
    }
}
