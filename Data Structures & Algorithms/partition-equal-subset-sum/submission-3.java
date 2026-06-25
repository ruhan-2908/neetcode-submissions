class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(0);
        for(int i = 0 ; i < nums.length ; i++)
        {
            HashSet<Integer> set2 = new HashSet<>();
            for(int total : set1)
            {
                if(total + nums[i] == target) return true;
                set2.add(total);
                set2.add(total + nums[i]);
            }
            set1 = set2;
        }
        return false;
    }
}
