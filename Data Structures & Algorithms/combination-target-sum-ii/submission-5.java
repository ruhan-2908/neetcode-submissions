class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,new ArrayList<>());
        return ans;
    }
    public void backtrack(int i , int[] candidates, int target , List<Integer> list)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || i >= candidates.length) return;
        list.add(candidates[i]);
        backtrack(i+1,candidates,target - candidates[i],list);
        list.remove(list.size() - 1);

        while(i+1<candidates.length && candidates[i] == candidates[i+1]) i++;
        backtrack(i+1,candidates,target,list);
    }
}
