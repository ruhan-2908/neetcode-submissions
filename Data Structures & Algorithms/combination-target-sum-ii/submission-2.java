class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,0,candidates,target,new ArrayList<Integer>());
        return list;
    }
    private void backtrack(int i , int sum, int[] candidates, int target, ArrayList<Integer> curList)
    {
        if(sum == target)
        {
            list.add(new ArrayList<>(curList));
            return;
        }
        if(target < sum || i>=candidates.length)
        {
            return;
        }
        curList.add(candidates[i]);
        backtrack(i+1,sum+candidates[i],candidates,target,curList);
        curList.remove(curList.size() - 1);

        while(i+1<candidates.length && candidates[i] == candidates[i+1]) i++;

        backtrack(i+1,sum,candidates, target, curList);
        
    }
}
