class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for(int i=0;i<order.length();i++)
        {
            rank[order.charAt(i) - 'a'] = i;
        }
        for(int i=0; i< words.length - 1 ; i++)
        {
            String str1 = words[i];
            String str2 = words[i+1];

            int j = 0;
            while(j < str1.length() && j < str2.length())
            {
                if( str1.charAt(j) != str2.charAt(j))
                {
                    if(rank[str1.charAt(j) - 'a'] > rank[str2.charAt(j) - 'a'])
                    {
                        return false;
                    }
                    break;
                }
                j++;
            }


            if( j == str2.length() && str1.length() > str2.length())
            {
                return false;
            }
        }
        return true;
    }
}