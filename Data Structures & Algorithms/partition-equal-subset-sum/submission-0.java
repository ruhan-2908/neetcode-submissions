class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for(int i = nums.length - 1 ; i >= 0 ; i--)
        {
            HashSet<Integer> dp = new HashSet<>();
            for(int t : set)
            {
                if(t + nums[i] == target) return true;
                dp.add(t+nums[i]);
                dp.add(t);
            }
            set = dp;
        }
        return false;
    }
}
