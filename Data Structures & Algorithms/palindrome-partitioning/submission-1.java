class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        dfs(s,new ArrayList<>(),0);
        return ans;
    }
    public void dfs(String s , List<String> curList , int idx)
    {
        if(idx >= s.length())
        {
            ans.add(new ArrayList<>(curList));
            return;
        }
        for(int i = idx; i < s.length() ; i++)
        {
            if(isPal(s,idx,i))
            {
                curList.add(s.substring(idx,i+1));
                dfs(s,curList,i+1);
                curList.remove(curList.size() - 1);
            }
        }
    }
    public boolean isPal(String s, int i, int j)
    {
        while(i<j)
        {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
