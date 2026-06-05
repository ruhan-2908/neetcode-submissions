class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String,HashSet<Character>> grid = new HashMap<>();
        HashMap<Integer,HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer,HashSet<Character>> cols = new HashMap<>();
        for(int r = 0 ; r < board.length ; r++)
        {
            for(int c = 0 ; c < board[0].length ; c++)
            {
                if(board[r][c] == '.') continue;
                String curr = (r/3) + "," + (c/3);
                rows.putIfAbsent(r,new HashSet<>());
                cols.putIfAbsent(c,new HashSet<>());
                grid.putIfAbsent(curr,new HashSet<>());
                char ch = board[r][c];
                if(rows.get(r).contains(ch) || cols.get(c).contains(ch) || grid.get(curr).contains(ch)) return false;
                rows.get(r).add(ch);
                cols.get(c).add(ch);
                grid.get(curr).add(ch);
            }
        }
        return true;
    }
}
