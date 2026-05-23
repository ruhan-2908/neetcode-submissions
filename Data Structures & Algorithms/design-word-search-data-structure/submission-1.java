class Node
{
    private boolean isWord;
    private Node[] children;

    Node()
    {
        this.isWord = false;
        this.children = new Node[26];
    }
}

class WordDictionary {
    Node head;
    public WordDictionary() {
        head = new Node();
    }

    public void addWord(String word) {
        Node temp = head;
        for(char ch : word.toCharArray())
        {
            int pos = ch - 'a';
            if(temp.children[pos] == null) temp.children[pos] = new Node();
            temp = temp.children[pos];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        return backtrack(word,0,head);
    }

    public boolean backtrack(String word, int i , Node temp)
    {
        if(i >= word.length()) return temp.isWord;

        if(word.charAt(i) == '.')
        {
            for(int j = 0 ; j < 26 ; j++)
            {
                if(temp.children[j] != null && backtrack(word,i+1,temp.children[j])) return true;
            }
        }else
        {
            return temp.children[word.charAt(i) - 'a']!=null ? backtrack(word,i+1,temp.children[word.charAt(i) - 'a']) : false;
        }
        return false;
    }
}
