class Solution {
    HashMap<Integer,Integer> map;
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num,0)+1);
        ans = new ArrayList<>();
        dfs(nums,new ArrayList<>());
        return ans;
    }   
    public void dfs(int[] nums, List<Integer> perm)
    {
        if(nums.length == perm.size())
        {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for(int num : map.keySet())
        {
            if(map.get(num) > 0)
            {
                perm.add(num);
                map.put(num,map.get(num) - 1);
                dfs(nums,perm);
                perm.remove(perm.size() - 1);
                map.put(num,map.get(num)+1);
            }
        }
    }
}