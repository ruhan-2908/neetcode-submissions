class Solution {
    private List<String> ans;
    private List<String> dict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = wordDict;
        ans = new ArrayList<>();
        backtrack(0,s,new ArrayList<>());
        return ans;
    }
    public void backtrack(int i , String s , ArrayList<String> temp)
    {
        if(i >= s.length())
        {
            StringBuilder sb = new StringBuilder();
            for(String str : temp)
            {
                sb.append(str + " ");
            }
            ans.add(sb.toString().trim());
            return;
        }
        for(int j = i ; j < s.length() ; j++)
        {
            if(dict.contains(s.substring(i,j+1)))
            {
                temp.add(s.substring(i,j+1));
                backtrack(j+1,s,temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}