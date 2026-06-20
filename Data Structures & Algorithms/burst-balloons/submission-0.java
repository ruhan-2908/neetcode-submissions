class Solution {
    HashMap<String,Integer> map;
    public int maxCoins(int[] nums) {
        int[] home = new int[nums.length + 2];
        home[0] = home[nums.length + 1] = 1;
        for(int i = 1 ; i <= nums.length ; i++) home[i] = nums[i-1];
        map = new HashMap<>();
        return dfs(home,1,nums.length);
    }
    public int dfs(int[] nums, int l , int r)
    {
        if(l > r) return 0;
        String curr = l + "," + r;
        if(map.containsKey(curr)) return map.get(curr);

        map.put(curr,0);
        for(int i = l ; i <= r ; i++)
        {
            int coins = nums[l-1] * nums[i] * nums[r+1];
            coins += dfs(nums,l,i-1) + dfs(nums,i+1,r);
            map.put(curr,Math.max(map.get(curr),coins));
        }

        return map.get(curr);
    }
}
