class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(target,1);

        for(int total = target ; total >= 0 ; total--)
        {
            for(int num : nums)
            {
                if(num > total) break;
                map.put(total - num, map.getOrDefault(total,0) + map.getOrDefault(total-num,0));
            }
        }


        return map.getOrDefault(0,0);
    }
}