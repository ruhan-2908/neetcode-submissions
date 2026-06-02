class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for(int i = 0 ; i < 26 ; i++)
        {
            rank[order.charAt(i) - 'a'] = i;
        }
        for(int i = 0 ; i < words.length - 1; i++)
        {
            String word1 = words[i];
            String word2 = words[i+1];
            int j = 0 ;
            while(j < word1.length() && j < word2.length())
            {
                if(word1.charAt(j) != word2.charAt(j)) 
                {
                    if(rank[word1.charAt(j)-'a'] > rank[word2.charAt(j) - 'a'])
                    {
                        return false;
                    }
                    break;
                }
                j++;
            }
            if(j == word2.length() && j < word1.length()) return false;
        }
        return true;
    }
}