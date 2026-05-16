class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] home = new boolean[nums.length];
        for(int i : nums)
        {
            if(i>0 && i<=nums.length)
            {
                home[i-1] = true;
            }
        }
        int i;
        for(i=0;i<nums.length;i++)
        {
            if(!home[i])
            {
                return i+1;
            }
        }
        return i+1;
    }
}