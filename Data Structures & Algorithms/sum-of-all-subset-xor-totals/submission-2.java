class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        dfs(nums,new ArrayList<>(),0);
        return res;    
    }
    public void dfs(int[] nums, List<Integer> list, int i)
    {
        int sum = 0;
        for(int el : list) sum = sum ^ el;
        res += sum;
        for(int j = i ; j < nums.length ; j++)
        {
            list.add(nums[j]);
            dfs(nums,list,j+1);
            list.remove(list.size() - 1);
        }
    }
}