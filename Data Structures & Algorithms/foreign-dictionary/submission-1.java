class Solution {
    HashMap<Character,HashSet<Character>> adj = new HashMap<>();
    HashMap<Character,Boolean> visited = new HashMap<>();
    List<Character> result = new ArrayList<>(); 
    public String foreignDictionary(String[] words) {
        for(String word : words)
        {
            for(char ch : word.toCharArray())
            {
                adj.putIfAbsent(ch,new HashSet<>());
            }
        }

        for(int i=0;i<words.length - 1 ; i++)
        {
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(),w2.length());
            if(w1.length() > w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen)))
            {
                return "";
            }
            for(int j=0;j<minLen;j++)
            {
                if(w1.charAt(j) != w2.charAt(j))
                {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
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
        for(char chi : adj.get(ch))
        {
            if(dfs(chi))
            {
                return true;
            }
        }
        visited.put(ch,false);
        result.add(ch);
        return false;
    }
}
