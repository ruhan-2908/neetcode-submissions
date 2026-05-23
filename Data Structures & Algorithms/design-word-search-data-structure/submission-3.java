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

class WordDictionary {
    Node head;
    public WordDictionary() {
        head = new Node();
    }

    public void addWord(String word) {
        head.insert(word);
    }

    public boolean search(String word) {
        return backtrack(0,word,head);
    }

    public boolean backtrack(int idx, String word , Node head)
    {
        if(idx >= word.length()) return head.isWord;
        if(word.charAt(idx) == '.')
        {
            for(char ch : head.children.keySet())
            {
                if(backtrack(idx+1,word,head.children.get(ch))) return true;
            }
        }else
        {
            return head.children.containsKey(word.charAt(idx)) ? backtrack(idx+1,word,head.children.get(word.charAt(idx))) : false;
        }
        return false;
    }
}
