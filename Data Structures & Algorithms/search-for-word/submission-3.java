class Solution {
    int ROWS ;
    int COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for(int i = 0 ; i < ROWS ; i++)
        {
            for(int j = 0 ; j < COLS ; j++)
            {
                if(dfs(board,word,i,j,0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i , int j , int idx)
    {
        if(idx >= word.length()) return true;

        if(i < 0 || j < 0 || i >= ROWS || j >= COLS || board[i][j] != word.charAt(idx) || board[i][j] == '.')
        {
            return false;
        }
        board[i][j] = '.';
        boolean top = dfs(board,word,i-1,j,idx+1);
        boolean left = dfs(board,word,i,j-1,idx+1);
        boolean right = dfs(board,word,i,j+1,idx+1);
        boolean bottom = dfs(board,word,i+1,j,idx+1);

        board[i][j] = word.charAt(idx);
        return top || left || right || bottom;
    }
}
