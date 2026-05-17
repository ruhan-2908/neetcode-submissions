class Solution {
    public String minWindow(String s, String t) {
       if(t.isEmpty()) return  "";
       HashMap<Character,Integer> smap = new HashMap<>();
       HashMap<Character,Integer> tmap = new HashMap<>();
       for(char ch : t.toCharArray())
       {
          tmap.put(ch,tmap.getOrDefault(ch,0)+1);
       } 
       int need = tmap.size();
       int have = 0;
       int[] res = {-1,-1};
       int resLen = Integer.MAX_VALUE;
       int start = 0;
       for(int i = 0 ; i < s.length() ; i++)
       {
            char ch = s.charAt(i);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
            if(tmap.containsKey(ch) && smap.get(ch) == tmap.get(ch))
            {
                have++;
            }
            while(have == need)
            {
                if(i-start+1 < resLen)
                {
                    resLen = i-start+1;
                    res[0] = start;
                    res[1] = i;
                }
                char cho = s.charAt(start);
                start++;
                smap.put(cho,smap.get(cho)-1);
                if(tmap.containsKey(cho) && smap.get(cho) < tmap.get(cho))
                {
                    have--;
                } 
            }
       }
       return resLen == Integer.MAX_VALUE ? "": s.substring(res[0],res[1]+1);
    }
}
