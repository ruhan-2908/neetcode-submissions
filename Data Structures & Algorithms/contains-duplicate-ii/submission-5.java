class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int start = 0;
        int end = 0;
        while(end < nums.length)
        {
            if((end - start) > k)
            {
                set.remove(nums[start]);
                start++;
            }
            if(set.contains(nums[end])) return true;
            set.add(nums[end]);
            end++;
        }
        return false;
    }
}