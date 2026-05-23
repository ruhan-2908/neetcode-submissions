class Solution {
    List<String> ans;
    StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        sb = new StringBuilder();
        backtrack(0,0,n);
        return ans;
    }
    public void backtrack(int open , int closed , int n)
    {
        if(open == closed && open == n)
        {
            ans.add(sb.toString());
            return;
        }
        if(open < n)
        {
            sb.append('(');
            backtrack(open+1,closed,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(closed < open)
        {
            sb.append(')');
            backtrack(open,closed+1,n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
