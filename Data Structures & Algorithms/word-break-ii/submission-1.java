class Solution {
    List<String> ans;
    HashSet<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        for(String str : wordDict) set.add(str);
        backtrack(0,s,new ArrayList<>());
        return ans;
    }
    public void backtrack(int i, String s, List<String> curList)
    {
        if(i >= s.length())
        {
            String whole = String.join(" ",curList);
            ans.add(whole);
            return;
        }
        for(int j = i ; j < s.length() ; j++)
        {
            if(set.contains(s.substring(i,j+1)))
            {   
                curList.add(s.substring(i,j+1));
                backtrack(j+1,s,curList);
                curList.remove(curList.size() - 1);
            }
        }
    }
}