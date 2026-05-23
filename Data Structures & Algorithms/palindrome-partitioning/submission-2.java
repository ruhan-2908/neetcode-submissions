class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        backtrack(s,0,new ArrayList<>());
        return ans;
    }
    public void backtrack(String s , int i , List<String> curList)
    {
        if(i >= s.length())
        {
            ans.add(new ArrayList<>(curList));
            return;
        }
        for(int j = i ; j < s.length() ; j++)
        {
            if(isPal(s,i,j))
            {
                curList.add(s.substring(i,j+1));
                backtrack(s,j+1,curList);
                curList.remove(curList.size() - 1);
            }
        }
    }
    public boolean isPal(String s , int i , int j)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
