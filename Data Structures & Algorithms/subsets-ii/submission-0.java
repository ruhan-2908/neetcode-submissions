class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<>());
        return list;
    }
    private void backtrack(int i, int[] nums, ArrayList<Integer> curList)
    {
        if(i==nums.length)
        {
            list.add(new ArrayList<>(curList));
            return;
        }

        curList.add(nums[i]);
        backtrack(i+1,nums,curList);
        curList.remove(curList.size() - 1);
        while(i+1<nums.length && nums[i] == nums[i+1]) i++;

        backtrack(i+1,nums,curList);
        
    }
}
