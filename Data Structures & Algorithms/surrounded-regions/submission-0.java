class Solution {
    int n;
    int m;
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;

        for(int c = 0 ; c < m ; c++)
        {
            capture(0,c,board);
            capture(n-1,c,board);
        }

        for(int r=0;r< n ;r++)
        {
            capture(r,0,board);
            capture(r,m-1,board);
        }

        for(int r=0;r<n;r++)
        {
            for(int c=0;c<m;c++)
            {
                if(board[r][c] == 'O') board[r][c] = 'X';
                else if( board[r][c] == 'T') board[r][c] = 'O';
            }
        }
        return;
    }
    public void capture(int r , int c , char[][] board)
    {
        if(r <0 || c < 0 || r >= n || c >= m || board[r][c] != 'O') return;
        board[r][c] = 'T';
        capture(r+1,c,board);
        capture(r-1,c,board);
        capture(r,c+1,board);
        capture(r,c-1,board);
    }
}
