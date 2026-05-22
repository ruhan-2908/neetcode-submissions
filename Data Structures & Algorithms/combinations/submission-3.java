class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        dfs(n,k,1,new ArrayList<>());
        return ans;
    }
    public void dfs(int n , int k , int i , List<Integer> list)
    {
        if(list.size() == k) 
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j = i ; j <= n ; j++)
        {
            list.add(j);
            dfs(n,k,j+1,list);
            list.remove(list.size() - 1);
        }
    }
}