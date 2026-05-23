class Solution {
    HashSet<Integer> posDia;
    HashSet<Integer> negDia;
    HashSet<Integer> cols;
    int ans;
    public int totalNQueens(int n) {
        ans=0;
        posDia = new HashSet<>();
        negDia = new HashSet<>();
        cols = new HashSet<>();
        char[][] board = new char[n][n];
        for(char[] b : board) Arrays.fill(b,'.');
        backtrack(0,board,n);
        return ans;
    }
    public void backtrack(int r , char[][] board,int n)
    {
        if(r >= n)
        {
            ans += 1;
            return;
        }
        for(int c = 0 ; c < n ; c++)
        {
            if(cols.contains(c) || posDia.contains(r+c) || negDia.contains(r-c)) continue;
            board[r][c] = 'Q';
            cols.add(c);
            posDia.add(r+c);
            negDia.add(r-c);
            backtrack(r+1,board,n);
            cols.remove(c);
            posDia.remove(r+c);
            negDia.remove(r-c);
            board[r][c] = '.';
        }
    }
}