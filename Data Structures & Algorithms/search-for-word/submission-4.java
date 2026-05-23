class Solution {
    int ROWS;
    int COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for(int r= 0 ; r < ROWS ; r++)
        {
            for(int c = 0 ; c < COLS ; c++)
            {
                if(board[r][c]  != word.charAt(0)) continue;
                if(backtrack(r,c,word,board,0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(int r , int c , String word , char[][] board, int idx)
    {
        if(idx >= word.length()) return true;
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || word.charAt(idx) != board[r][c] || board[r][c] == '#') return false;

        board[r][c] = '#';
        boolean top = backtrack(r-1,c,word,board,idx+1);
        boolean bottom = backtrack(r+1,c,word,board,idx+1);
        boolean left = backtrack(r,c-1,word,board,idx+1);
        boolean right = backtrack(r,c+1,word,board,idx+1);
        board[r][c] = word.charAt(idx);

        return top || bottom || left || right;
    }
}
