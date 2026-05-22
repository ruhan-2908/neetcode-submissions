class Solution {
    List<String> ans;
    StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        sb = new StringBuilder();
        ans = new ArrayList<>();
        dfs(n,0,0);
        return ans;
    }
    public void dfs(int n, int open, int closed)
    {
        if(open == closed && open == n)
        {
            ans.add(sb.toString());
            return;
        }
        if(open < n)
        {
            sb.append("(");
            dfs(n,open+1,closed);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(closed < open)
        {
            sb.append(")");
            dfs(n,open,closed+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
