class Solution {
    private HashSet<Integer> col = new HashSet<>();
    private HashSet<Integer> posDia = new HashSet<>();
    private HashSet<Integer> negDia = new HashSet<>();
    private List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char[][] home = new char[n][n];
        for(char[] boardrow : home)
        {
            Arrays.fill(boardrow,'.');
        }
        backtrack(0,n,home);
        return ans;
    }
    public void backtrack(int r, int n , char[][] home)
    {
        if(r == n)
        {
            List<String> oneAns = new ArrayList<>();
            for(char[] i : home)
            {
                oneAns.add(new String(i));
            }
            ans.add(oneAns);
            return;
        }
        for(int c = 0 ; c < n ; c++)
        {
            if( col.contains(c) || posDia.contains(r+c) || negDia.contains(r-c)) continue;

            col.add(c);
            posDia.add(r+c);
            negDia.add(r-c);
            home[r][c] = 'Q';

            backtrack(r+1,n,home);
            
            col.remove(c);
            posDia.remove(r+c);
            negDia.remove(r-c);
            home[r][c] = '.';
        }
    }
}
