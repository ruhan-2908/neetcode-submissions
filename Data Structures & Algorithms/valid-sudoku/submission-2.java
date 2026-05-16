class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Integer>> rows = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> cols = new HashMap<>();
        HashMap<String,HashSet<Integer>> sq = new HashMap<>();

        int ROWS = board.length;
        int COLS = board[0].length;

        for(int r=0;r<ROWS;r++)
        {
            for(int c=0;c<COLS;c++)
            {
                if(board[r][c] == '.') continue;
                int num = board[r][c] + '0';
                String temp = (r/3) + " , " + (c/3);
                rows.putIfAbsent(r,new HashSet<Integer>());
                cols.putIfAbsent(c,new HashSet<Integer>());
                sq.putIfAbsent(temp,new HashSet<Integer>());
                if(rows.get(r).contains(num) || cols.get(c).contains(num) || sq.get(temp).contains(num))
                {
                    return false;
                }
                rows.get(r).add(num);
                cols.get(c).add(num);
                sq.get(temp).add(num);
            }
        }   
        return true;
    }
}
