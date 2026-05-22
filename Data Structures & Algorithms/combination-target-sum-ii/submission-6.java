class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),0);
        return ans;
    }
    public void dfs(int[] candidates,int target,List<Integer> list,int i)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || i >= candidates.length) return;
        

        list.add(candidates[i]);
        dfs(candidates,target-candidates[i],list,i+1);
        list.remove(list.size() - 1);

        while(i+1<candidates.length && candidates[i] == candidates[i+1]) i++;

        dfs(candidates,target,list,i+1);
    }
}
