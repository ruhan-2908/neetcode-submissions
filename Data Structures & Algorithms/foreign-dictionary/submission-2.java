class Solution {
    HashMap<Character,List<Character>> adj;
    List<Character> result = new ArrayList<>();
    HashMap<Character,Boolean> visited = new HashMap<>();
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        for(String word : words)
        {
            for(int i = 0 ; i < word.length() ; i++) adj.putIfAbsent(word.charAt(i),new ArrayList<>());
        }
        for(int i = 0 ; i < words.length -1 ; i++)
        {
            String word1 = words[i];
            String word2 = words[i+1];
            int minLen = Math.min(word1.length(),word2.length());
            if(word1.length() > word2.length() && word1.substring(0,minLen).equals(word2.substring(0,minLen))) return "";
            int j = 0;
            while(j < minLen)
            {
                if(word1.charAt(j) != word2.charAt(j)) 
                {
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
                j++;
            }
        }
        for(char ch : adj.keySet())
        {
            if(dfs(ch))
            {
                return "";
            }
        }
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for(char ch : result)
        {
            sb.append(ch);
        }
        return sb.toString();
    }
    public boolean dfs(char ch)
    {
        if(visited.containsKey(ch)) return visited.get(ch);
        visited.put(ch,true);
        for(char nei : adj.get(ch))
        {
            if(dfs(nei)) return true;
        }
        visited.put(ch,false);
        result.add(ch);
        return false;
    }
}
