class Solution {
    public boolean isMonotonic(int[] nums) {
        Boolean inc = null;

        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i-1] > nums[i])
            {
                if(inc != null)
                {
                    if(inc) return false;
                }
                else
                {
                    inc = false;
                }
            }else if (nums[i-1] < nums[i])
            {
                if(inc != null)
                {
                    if(!inc) return false;
                }else
                {
                    inc = true;
                }
            }
        }
        return true;
    }
}