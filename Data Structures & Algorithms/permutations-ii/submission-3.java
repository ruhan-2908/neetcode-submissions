class Solution {
    HashMap<Integer,Integer> map;
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        map = new HashMap<>();
        ans = new ArrayList<>();
        for(int num : nums) map.put(num, map.getOrDefault(num,0)+1);
        dfs(nums.length,new ArrayList<>());
        return ans;
    }
    public void dfs(int size, List<Integer> list)
    {
        if(list.size() == size)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int num : map.keySet())
        {
            if(map.get(num) > 0)
            {
                list.add(num);
                map.put(num,map.get(num)-1);
                dfs(size,list);
                list.remove(list.size() - 1);
                map.put(num,map.get(num)+1);
            }
        }
    }
}