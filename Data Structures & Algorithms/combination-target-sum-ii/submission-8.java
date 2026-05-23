class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,new ArrayList<>());
        return ans;
    }
    public void backtrack(int i, int[] candidates, int target, List<Integer> curList)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(curList));
            return;
        }
        if(target < 0 || i >= candidates.length) return;
        curList.add(candidates[i]);
        backtrack(i+1,candidates,target-candidates[i],curList);
        curList.remove(curList.size() - 1);

        while(i+1 < candidates.length && candidates[i] == candidates[i+1]) i++;
        backtrack(i+1,candidates,target,curList);
    }
}
