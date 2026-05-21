class Solution {
    List<String> res;
    StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        sb = new StringBuilder();
        res = new ArrayList<>();
        backtrack(0,0,n);
        return res;
    }
    public void backtrack(int open , int close , int n)
    {
        if(open == close && open == n)
        {
            res.add(sb.toString());
            return;
        }
        if(open < n)
        {
            sb.append('(');
            backtrack(open+1,close,n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open)
        {
            sb.append(')');
            backtrack(open,close+1,n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
