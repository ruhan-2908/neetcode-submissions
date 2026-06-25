class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer>[] map = new HashMap[n+1];
        for(int i = 0 ; i <= n ; i++) map[i] = new HashMap<>();
        map[0].put(0,1);
        for(int i = 0 ; i < n ; i++)
        {
            for(Map.Entry<Integer,Integer> entry : map[i].entrySet())
            {
                int value = entry.getKey();
                int count = entry.getValue();
                map[i+1].put(value + nums[i],map[i+1].getOrDefault(value+nums[i],0)+count);
                map[i+1].put(value - nums[i],map[i+1].getOrDefault(value-nums[i],0)+count);
            }
        }
        return map[n].getOrDefault(target,0);
    }
}
