class Node
{
    boolean isWord;
    Node[] children;
    
    Node()
    {
        this.isWord = false;
        this.children = new Node[26];
    }
}
class PrefixTree {
    Node head;
    public PrefixTree() {
        head = new Node();
    }

    public void insert(String word) {
        Node temp = head;
        for(char ch : word.toCharArray())
        {
            int pos = ch - 'a';
            if(temp.children[pos] == null)
            {
                temp.children[pos] = new Node();
            }
            temp = temp.children[pos];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        Node temp = head;
        for(char ch : word.toCharArray())
        {
            int pos = ch - 'a';
            if(temp.children[pos] == null) return false;
            temp = temp.children[pos];
        }
        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        Node temp = head;
        for(char ch : prefix.toCharArray())
        {
            int pos = ch - 'a';
            if(temp.children[pos] == null) return false;
            temp = temp.children[pos];
        }
        return true;
    }
}
