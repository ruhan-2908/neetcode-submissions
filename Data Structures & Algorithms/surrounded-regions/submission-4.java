class Solution {
    int ROWS;
    int COLS;
    public void solve(char[][] board) {
        List<int[]> points =new ArrayList<>();
        ROWS = board.length ;
        COLS = board[0].length;
        for(int c = 0 ; c < COLS ; c++)
        {
            capture(0,c,board);
            capture(ROWS-1,c,board);
        }
        for(int r = 0 ; r < ROWS ; r++)
        {
            capture(r,0,board);
            capture(r,COLS-1,board);
        }
        for(int r = 0 ; r < ROWS ; r++)
        {
            for(int c =0 ; c < COLS ; c++)
            {
                if(board[r][c] == 'O') board[r][c] = 'X';
                else if(board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }
    public void capture(int r , int c , char[][] board)
    {
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != 'O') return;
        board[r][c] = 'T';
        capture(r+1,c,board);
        capture(r-1,c,board);
        capture(r,c+1,board);
        capture(r,c-1,board);
    }
}
