class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int left = 1;
        int right = 1;
        for(int i =0 ; i < nums.length ; i++)
        {
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;

            left = left * nums[i];
            right = right * nums[nums.length - i - 1];

            max = Math.max(max,Math.max(left,right)); 
        }
        return max;
    }
}
