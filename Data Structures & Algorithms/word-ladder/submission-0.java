class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> words = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int res = 0;
        while(!q.isEmpty())   
        {
            res++;
            int len = q.size();
            for(int i=0;i<len;i++)
            {
                String temp = q.poll();
                if(temp.equals(endWord)) return res;
                for(int j = 0 ; j< temp.length() ;j++)
                {
                    for(char c = 'a' ; c <= 'z' ; c++)
                    {
                        if(c == temp.charAt(j)) continue;
                        String r = temp.substring(0,j) + c + temp.substring(j+1);
                        if(words.contains(r))
                        {
                            q.offer(r);
                            words.remove(r);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
