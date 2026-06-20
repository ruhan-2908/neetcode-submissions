class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int currMax = 0;
        int currMin = 0;
        int total = 0;
        for(int num : nums)
        {
            currMin = Math.min(currMin + num,num);
            currMax = Math.max(currMax + num,num);
            total += num;
            max = Math.max(max,currMax);
            min = Math.min(min,currMin);
        }

        return max > 0 ? Math.max(max,total - min) : max;
    }
}