public class Node
{
    HashMap<Character,Node> children;
    boolean isWord;
    Node()
    {
        children = new HashMap<>();
        isWord = false;
    }
    public void addWord(String word)
    {
        Node cur = this;
        for(char ch : word.toCharArray())
        {
            cur.children.putIfAbsent(ch,new Node());
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }
}
class Solution {
    boolean[][] visited;
    Set<String> res;
    int ROWS;
    int COLS;
    public List<String> findWords(char[][] board, String[] words) {
        Node head = new Node();
        ROWS = board.length;
        COLS = board[0].length;
        res = new HashSet<>();
        visited = new boolean[ROWS][COLS];
        for(String word : words)
        {
            head.addWord(word);
        }
        for(int r = 0 ; r < ROWS ; r++)
        {
            for(int c = 0 ; c < COLS ; c++)
            {
                backtrack(r,c,"",head,board);
            }
        }
        return new ArrayList<>(res);
    }
    public void backtrack(int r , int c ,String word, Node cur,char[][] board)
    {
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || !cur.children.containsKey(board[r][c]) || visited[r][c]) return;
        visited[r][c] = true;
        cur = cur.children.get(board[r][c]);
        word = word + board[r][c];
        if(cur.isWord) res.add(word);
        backtrack(r+1,c,word,cur,board);
        backtrack(r-1,c,word,cur,board);
        backtrack(r,c+1,word,cur,board);
        backtrack(r,c-1,word,cur,board);
        visited[r][c] = false;
    }
}
