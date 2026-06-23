class Solution {
    public int missingNumber(int[] nums) {
        int ideal = nums.length * (nums.length + 1);
        ideal = ideal / 2;
        int actual = 0;
        for(int num : nums) actual += num;
        return ideal - actual;
    }
}
