class Solution {
    List<List<String>> ans;
    HashSet<Integer> posDia;
    HashSet<Integer> negDia;
    HashSet<Integer> cols;
    public List<List<String>> solveNQueens(int n) {
        cols = new HashSet<>();
        ans = new ArrayList<>();
        posDia = new HashSet<>();
        negDia = new HashSet<>();
        char[][] board = new char[n][n];
        for(char[] b : board) Arrays.fill(b,'.');
        backtrack(0,n,board);
        return ans;
    }
    public void backtrack(int r,int n ,char[][] board)
    {
        if(r >= n) 
        {
            List<String> curList = new ArrayList<>();
            for(char[] b : board) curList.add(new String(b));
            ans.add(curList);
            return;
        }
        for(int c = 0 ; c < n ; c++)
        {
            if(cols.contains(c) || posDia.contains(r+c) || negDia.contains(r-c)) continue;
            board[r][c] = 'Q';
            cols.add(c);
            posDia.add(r+c);
            negDia.add(r-c);
            backtrack(r+1,n,board);
            board[r][c] = '.';
            cols.remove(c);
            posDia.remove(r+c);
            negDia.remove(r-c);
        }
    }
}
