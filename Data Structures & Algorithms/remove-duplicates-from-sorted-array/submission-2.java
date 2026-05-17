class Solution {
    public int removeDuplicates(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       int idx  = 0;
       for(int i=0;i<nums.length;i++) 
       {
        if (!set.contains(nums[i]))
        {
            nums[idx++] = nums[i];
            set.add(nums[i]);
        }   
       }
       return idx;

    }
}