class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Integer>> rows = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> cols = new HashMap<>();
        HashMap<String,HashSet<Integer>> sqs = new HashMap<>();

        for(int r=0;r<9;r++)
        {
            for(int c = 0 ; c < 9;c++)
            {
                if(board[r][c] == '.')continue;
                String square = (r/3) +","+ (c/3);
                int num = board[r][c] + '0';
                rows.putIfAbsent(r,new HashSet<>());
                cols.putIfAbsent(c,new HashSet<>());
                sqs.putIfAbsent(square,new HashSet<>());
                if(rows.get(r).contains(num) || cols.get(c).contains(num) || sqs.get(square).contains(num))
                {
                    return false;
                } 
                rows.get(r).add(num);
                cols.get(c).add(num);
                sqs.get(square).add(num);
            }
        }
        return true;
    }
}
