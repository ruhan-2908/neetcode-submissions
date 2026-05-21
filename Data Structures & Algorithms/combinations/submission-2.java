class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        backtrack(1,n,k, new ArrayList<>());
        return ans;
    }
    public void backtrack(int i , int n , int k, List<Integer> list)
    {
        if(list.size() == k)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j = i ; j <= n ; j++)
        {
            list.add(j);
            backtrack(j+1,n,k,list);
            list.remove(list.size() - 1);
        }
    }
}