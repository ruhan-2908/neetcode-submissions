class Solution {
    private List<String> res;
    private StringBuilder str;
    public List<String> generateParenthesis(int n) {
        str = new StringBuilder();
        res = new ArrayList<String>();
        backtrack(0,0,n,str);
        return res;
    }
    private void backtrack(int open ,int close, int n , StringBuilder str)
    {
        if(open == close && open == n)
        {
            res.add(str.toString());
            return;
        }
        if(open < n)
        {
            str.append('(');
            backtrack(open+1,close,n,str);
            str.deleteCharAt(str.length() - 1);
        }
        if(close < open)
        {
            str.append(')');
            backtrack(open,close+1,n,str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
