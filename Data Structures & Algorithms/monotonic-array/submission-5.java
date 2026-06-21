class Solution {
    public boolean isMonotonic(int[] nums) {
        int inc = 0;
        int dec = 0;

        for(int i = 0 ; i < nums.length - 1 ; i++)
        {
            if(nums[i] == nums[i+1]) continue;
            if(nums[i] < nums[i+1])
            {
                if(dec == 1) return false;
                inc = 1;
            }else
            {
                if(inc == 1) return false;
                dec = 1;
            }
        }
        return true;
    }
}