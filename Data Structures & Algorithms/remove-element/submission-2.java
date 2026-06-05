class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for(int j = 0 ; j < nums.length ; j++)
        {
            if(nums[j] != val) nums[idx++] = nums[j];
        }
        return idx;
    }
}