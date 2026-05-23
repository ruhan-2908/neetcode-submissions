class Node
{
    boolean isWord;
    HashMap<Character,Node> children;

    Node()
    {
        this.isWord = false;
        children = new HashMap<>();
    }

    public void insert(String word)
    {
        Node head =this;
        for(char ch : word.toCharArray())
        {
            head.children.putIfAbsent(ch,new Node());
            head = head.children.get(ch);
        }
        head.isWord = true;
    }
}
class Solution {
    Set<String> ans;
    boolean[][] visited;
    int ROWS;
    int COLS;
    StringBuilder sb;
    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        sb = new StringBuilder();
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];
        ans = new HashSet<>();
        Node head = new Node();
        for(String str : words) head.insert(str);
        for(int r = 0 ; r < ROWS ; r++)
        {
            for(int c = 0 ; c < COLS ; c++)
            {
                backtrack(r,c,head,board);
            }
        }
        return new ArrayList<>(ans);
    }
    public void backtrack(int r , int c , Node head, char[][] board)
    {
        if(r < 0 || c < 0 || r>= ROWS || c >= COLS || visited[r][c] || !head.children.containsKey(board[r][c])) return;
        visited[r][c] = true;
        head = head.children.get(board[r][c]);
        sb.append(board[r][c]);
        if(head.isWord) ans.add(sb.toString());
        backtrack(r+1,c,head,board);
        backtrack(r-1,c,head,board);
        backtrack(r,c+1,head,board);
        backtrack(r,c-1,head,board);
        visited[r][c] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}
