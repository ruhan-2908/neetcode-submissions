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
class WordDictionary {
    Node head;
    public WordDictionary() {
        head = new Node();
    }

    public void addWord(String word) {
        Node temp = head;
        for(char ch : word.toCharArray())
        {
            if(temp.children[ch - 'a'] == null)
            {
                temp.children[ch - 'a'] = new Node();
            }
            temp = temp.children[ch-'a'];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        Node temp = head;
        return backtrack(0,word,temp);
    }
    public boolean backtrack(int i , String word, Node temp)
    {
        if(i>= word.length())
        {
            return temp.isWord;
        }
        if(word.charAt(i) == '.')
        {
            for(int j=0;j<26;j++)
            {
                if(temp.children[j] != null && backtrack(i+1,word,temp.children[j])) return true;
            }
        }else
        {
            return temp.children[word.charAt(i)-'a'] != null ?
                                                        backtrack(i+1,word,temp.children[word.charAt(i) - 'a']) : false;
        }
        return false;
    }
}
