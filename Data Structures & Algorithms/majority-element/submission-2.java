class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for(int i =  1; i< nums.length ; i++)
        {
            if(candidate == nums[i])count++;
            else if(count == 0)
            {
                count = 1;
                candidate = nums[i];
            } else
            {
                count--;
            }
        }
        return candidate;
    }
}