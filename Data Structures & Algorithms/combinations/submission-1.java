class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        backtrack(0,n,k,new ArrayList<>());
        return list;
    }
    private void backtrack(int i , int n , int k , ArrayList<Integer> curList)
    {
        if(curList.size() == k) 
        {
            list.add(new ArrayList<>(curList));
            return;
        }
        for(int j = i;j<n;j++)
        {
            curList.add(j+1);
            backtrack(j+1,n,k,curList);
            curList.remove(curList.size() - 1);
        }
    }
}