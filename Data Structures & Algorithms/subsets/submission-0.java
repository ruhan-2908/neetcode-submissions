class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>());
        return list;
    }
    private void backtrack(int i,int[] nums , ArrayList<Integer> curList)
    {
        list.add(new ArrayList<>(curList));
        for(int j=i;j<nums.length;j++)
        {
            curList.add(nums[j]);
            backtrack(j+1,nums,curList);
            curList.remove(curList.size() -1);
        }
    }
}
