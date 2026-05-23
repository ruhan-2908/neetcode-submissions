class Solution {
    HashMap<Integer,Integer> count;
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        count = new HashMap<>();
        for(int num : nums) count.put(num,count.getOrDefault(num,0)+1);
        backtrack(0,nums,new ArrayList<>());
        return ans;
    }
    public void backtrack(int i , int[] nums, List<Integer> list)
    {
        if(i>= nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int key : count.keySet())
        {
            if(count.get(key) > 0)
            {
                list.add(key);
                count.put(key,count.get(key)-1);
                backtrack(i+1,nums,list);
                list.remove(list.size() - 1);
                count.put(key,count.get(key)+1);
            }
        }
    }
}