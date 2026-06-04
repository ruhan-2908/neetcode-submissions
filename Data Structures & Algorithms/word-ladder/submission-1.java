class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int moves = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size ; i++)
            {
                String word = q.poll();
                if(word.equals(endWord)) return moves+1;
                for(int j=0;j<word.length(); j++)
                {
                    for(char c = 'a' ; c <= 'z' ; c++)
                    {
                        if(c == word.charAt(j)) continue;
                        String nextWord = word.substring(0,j) + c + word.substring(j+1);
                        if(set.contains(nextWord))
                        {
                            q.offer(nextWord);
                            set.remove(nextWord);
                        }
                    }
                }
            }
            moves++;
        }
        return 0;
    }
}
