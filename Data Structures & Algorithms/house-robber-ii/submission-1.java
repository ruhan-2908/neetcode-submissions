class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];
        return Math.max(findMax(Arrays.copyOfRange(nums,0,nums.length-1)),findMax(Arrays.copyOfRange(nums,1,nums.length)));
    }
    public int findMax(int[] nums)
    {   
        int rob1 = 0;
        int rob2 = 0;
        for(int num : nums)
        {
            int temp = Math.max(rob2,rob1+num);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
