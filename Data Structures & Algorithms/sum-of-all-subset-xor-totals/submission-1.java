class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(nums,0,new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums, int i, ArrayList<Integer> list)
    {
        int temp = 0;
        for(int e : list) temp = temp ^ e;
        res += temp;
        for(int j = i ; j < nums.length ; j++)
        {
            list.add(nums[j]);
            backtrack(nums,j+1,list);
            list.remove(list.size() - 1);
        }
    }
}