public class Node
{
    private Node[] children;
    private boolean isWord;

    Node()
    {
        children = new Node[26];
        isWord = false;
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
            if(temp.children[ch-'a']==null)
            {
                temp.children[ch-'a'] = new Node();
            }
            temp = temp.children[ch-'a'];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {    
        Node temp = head;
        for(char ch : word.toCharArray())
        {
            if(temp.children[ch-'a'] == null)
            {
                return false;
            }
            temp = temp.children[ch-'a'];
        }
        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        Node temp = head;
        for(char ch : prefix.toCharArray())
        {
            if(temp.children[ch-'a'] == null)
            {
                return false;
            }
            temp = temp.children[ch-'a'];
        }
        return true;
    }
}
