class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for(int i = 0 ; i < nums.length ; i++)
        {
            HashSet<Integer> seto = new HashSet<>();
            for(int t : set)
            {
                if(t + nums[i] == target) return true;
                seto.add(t);
                seto.add(t + nums[i]); 
            }
            set = seto;
        }
        return false;
    }
}
