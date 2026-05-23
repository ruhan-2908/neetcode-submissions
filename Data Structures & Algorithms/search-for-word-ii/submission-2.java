class Node
{
    boolean isWord;
    HashMap<Character,Node> children;
    
    Node()
    {
        this.isWord = false;
        this.children = new HashMap<>();
    }

    public void insert(String word)
    {
        Node head = this;
        for(char ch : word.toCharArray())
        {
            head.children.putIfAbsent(ch,new Node());
            head = head.children.get(ch);
        }
        head.isWord = true;
    }
}
class Solution {
    boolean[][] visited;
    Set<String> ans;
    int ROWS;
    int COLS;
    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        ans = new HashSet<>();
        visited = new boolean[ROWS][COLS];
        Node head = new Node();
        for(String word : words) head.insert(word);
        for(int r = 0 ; r < ROWS ; r++)
        {
            for(int c = 0 ; c < COLS ; c++)
            {
                backtrack(r,c,"",head,board);
            }
        } 
        return new ArrayList<>(ans);
    }
    public void backtrack(int r , int c , String word ,Node head, char[][] board)
    {
        if(r<0 || c<0 || r >= ROWS || c >= COLS || !head.children.containsKey(board[r][c]) || visited[r][c]) return;

        visited[r][c] = true;
        head = head.children.get(board[r][c]);
        word = word + board[r][c];
        if(head.isWord) ans.add(word);
        backtrack(r+1,c,word,head,board);
        backtrack(r,c+1,word,head,board);
        backtrack(r-1,c,word,head,board);
        backtrack(r,c-1,word,head,board);
        visited[r][c] = false;
    }
}
