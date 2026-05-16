class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> home  = new HashMap<>();
        home.put(0,1);
        int res =0;
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum = sum + nums[i];
            if(home.containsKey(sum-k))
            {   
                res = res + home.get(sum-k);
            }
            home.put(sum,home.getOrDefault(sum,0)+1);
        }
        return res;
    }
}