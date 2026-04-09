class Solution {
    private int res = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(0,nums,new ArrayList<>());        
        return res;
    }
    private void backtrack(int i , int[] nums , ArrayList<Integer> list)
    {
        int temp = 0;
        for(int ele : list) temp = temp ^ ele;
        res += temp;
        for(int j=i;j<nums.length;j++)
        {
            list.add(nums[j]);
            backtrack(j+1,nums,list);
            list.remove(list.size() - 1);
        }
    }
}