class Solution {
    int ROWS;
    int COLS;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int c = 0 ; c < COLS ; c++)
        {
            dfs(0,c,board);
            dfs(ROWS-1,c,board);
        }

        for(int r =0 ; r < ROWS ; r++)
        {
            dfs(r,0,board);
            dfs(r,COLS-1,board);
        }

        for(int r = 0 ; r < ROWS ; r++)
        {
            for(int c = 0 ; c < COLS ; c++)
            {
                if(board[r][c] == 'T') board[r][c] = 'O';
                else if( board[r][c] == 'O') board[r][c] = 'X';
            }
        }
    }
    public void dfs(int r, int c , char[][] board)
    {
        if(board[r][c] != 'O') return;
        board[r][c] = 'T';
        for(int[] d : dir)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr <0 || nc < 0 || nr >= ROWS || nc >= COLS || board[nr][nc] != 'O')continue;
            dfs(nr,nc,board);
        }
    }
}
