class Solution {
    HashMap<Character,List<Character>> adj;
    List<Character> output;
    HashMap<Character,Boolean> visited;
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        output = new ArrayList<>();
        visited = new HashMap<>();
        for(String word : words)
        {
            for(char ch : word.toCharArray())
            {
                adj.putIfAbsent(ch , new ArrayList<>());
            }
        }

        for(int i = 0 ; i < words.length - 1; i++)
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
            if(dfs(ch)) return "";
        }

        Collections.reverse(output);
        StringBuilder sb = new StringBuilder();
        for(char ch : output) sb.append(ch);
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
        output.add(ch);
        return false;
    }
}
