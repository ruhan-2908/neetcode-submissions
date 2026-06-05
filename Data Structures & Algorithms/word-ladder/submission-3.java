class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord) || beginWord.equals(endWord)) return 0;
        int moves = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int s = 0 ; s < size ; s++)
            {
            String word = q.poll();
            if(word.equals(endWord)) return moves;
            for(int i = 0 ; i < word.length() ; i++)
            {
                for(char c = 'a' ; c <= 'z' ; c++)
                {
                    if(word.charAt(i) == c) continue;
                    String newWord = word.substring(0,i) + c + word.substring(i+1);
                    if(set.contains(newWord))
                    {
                    q.offer(newWord);
                    set.remove(newWord);
                    }
                }
            }
            }
            moves++;
        }
        return 0;
    }
}
